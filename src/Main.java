import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String args[]) {
        Map<Integer, Snake> snakeList = new HashMap<>();
        snakeList.put(99, new Snake(24));
        snakeList.put(67, new Snake(44));
        snakeList.put(74, new Snake(43));
        snakeList.put(77, new Snake(22));
        snakeList.put(22, new Snake(1));


        Map<Integer, Ladder> ladderList = new HashMap<>();
        ladderList.put(23, new Ladder(98));
        ladderList.put(12, new Ladder(44));
        ladderList.put(34, new Ladder(43));
        ladderList.put(3, new Ladder(22));
        ladderList.put(2, new Ladder(88));

        Game game = new Game(100, 7, new String[]{"Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7"}, 2, snakeList, ladderList);
        game.run();
    }
}

