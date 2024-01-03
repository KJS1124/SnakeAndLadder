public class Ladder implements SpecialEvent {
    private Integer finalPosition;

    public Ladder(Integer finalPosition) {
        this.finalPosition = finalPosition;
    }


    @Override
    public String getType() {
        return "Snake";
    }

    @Override
    public Integer nextPosition() {
        return finalPosition;
    }
}
