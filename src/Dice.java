public class Dice {
    private Integer sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public Integer roll() {
        return (int) (Math.random() * sides + 1);
    }
}
