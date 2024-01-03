public class Snake implements SpecialEvent {
    private Integer finalPosition;

    public Snake(Integer finalPosition) {
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
