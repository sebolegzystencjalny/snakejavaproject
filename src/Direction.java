/**
 * Wyliczenie reprezentujące kierunek poruszania się.
 */
public enum Direction {
    UP(new Point(0, -1)),
    RIGHT(new Point(1, 0)),
    DOWN(new Point(0, 1)),
    LEFT(new Point(-1, 0));
    

    private final Point point;
    
    /**
     * Konstruktor wyliczenia Direction.
     *
     * @param directionPoint Punkt reprezentujący kierunek poruszania się.
     */
    Direction(Point directionPoint) {
        this.point = directionPoint;
    }
    
    /**
     * Zwraca kierunek na podstawie danego punktu.
     *
     * @param directionPoint Punkt reprezentujący kierunek.
     * @return Kierunek poruszania się.
     */
    public static Direction getDirection(Point directionPoint){
        for (Direction direction : Direction.values()) {
            if(directionPoint.equals(direction.getPoint()))
                return direction;
        }
        return Direction.RIGHT;
    }
    
    /**
     * Zwraca punkt reprezentujący kierunek.
     *
     * @return Punkt reprezentujący kierunek.
     */
    public Point getPoint() {
        return point;
    }
    
    /**
     * Obraca kierunek o podaną rotację.
     *
     * @param rotation Rotacja do zastosowania.
     * @return Obrócony kierunek poruszania się.
     */
    public Direction rotate(Rotation rotation) {
        Direction[] values = Direction.values();
        int currentIndex = this.ordinal();
        int newIndex = (currentIndex + rotation.getValue()) % values.length;
        if (newIndex == -1)
            newIndex = 3;
        return values[newIndex];
    }
    
}