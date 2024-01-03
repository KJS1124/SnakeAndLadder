import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Game {
    private Map<Integer, Integer> playerPositions;
    private Set<Integer> winners;
    private List<Player> players;
    private List<Dice> dices;
    private Map<Integer, SpecialEvent> specialEventMap;
    private Integer boardSize;
    private Integer currentTurn;

    public Game(Integer boardSize, Integer numberOfPlayers, String names[], Integer numberOfDices, Map<Integer, Snake> snakes, Map<Integer, Ladder> ladders) {
        this.boardSize = boardSize;
        this.winners = new LinkedHashSet<>();
        this.players = new ArrayList<>();
        this.playerPositions = new HashMap<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            this.players.add(new Player(i, names[i]));
            this.playerPositions.put(i, 1);
        }

        dices = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++) {
            this.dices.add(new Dice(6));
        }

        this.specialEventMap = new HashMap<>();
        this.specialEventMap.putAll(snakes);
        this.specialEventMap.putAll(ladders);
        this.currentTurn = 0;
    }


    public void run() {
        while (winners.size() < players.size() - 1) {
            int turn = getCurrentTurn();
            if (winners.contains(turn)) {
                continue;
            }
            System.out.println("Player turn: " + players.get(turn).getName());
            int diceNumber = rollAllDices();
            System.out.println("Dice rolled to "+ diceNumber);
            int newPosition = (Integer) playerPositions.get(players.get(turn).getId()) + diceNumber;

            if(this.specialEventMap.containsKey(newPosition)) {
                newPosition = this.specialEventMap.get(newPosition).nextPosition();
            }

            if(newPosition <= boardSize) {
                playerPositions.put(turn, newPosition);
            } else {
                newPosition = playerPositions.get(turn);
            }
            System.out.println("Player " + players.get(turn).getName() + "is on" + newPosition);

            if (newPosition == this.boardSize) {
                System.out.println("player won : " + players.get(turn).getName());
                winners.add(players.get(turn).getId());
            }
        }

        System.out.println("Winners sequence");
        for(int x : winners) System.out.println(x);
    }

    private Integer rollAllDices() {
        int sum = 0;
        for (Dice dice : dices) {
            sum += dice.roll();
        }
        return sum;
    }

    public Integer getCurrentTurn() {
        return currentTurn++ % players.size();
    }
}
