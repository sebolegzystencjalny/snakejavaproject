public enum Direction {
    UP(new Point(0, -1)),
    RIGHT(new Point(1, 0)),
    DOWN(new Point(0, 1)),
    LEFT(new Point(-1, 0));
    

    private final Point point;

    Direction(Point directionPoint) {
        this.point = directionPoint;
    }

    public Point getPoint() {
        return point;
    }

    public Direction rotate(Rotation rotation) {
        Direction[] values = Direction.values();
        int currentIndex = this.ordinal();
        int newIndex = (currentIndex + rotation.getValue()) % values.length;
        return values[newIndex];
    }
}