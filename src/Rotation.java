public enum Rotation {
    RIGHT(1),
    LEFT(-1),
    FORWARD(0);

    private final int value;

    Rotation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}