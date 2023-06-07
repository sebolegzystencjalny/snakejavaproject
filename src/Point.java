/**
 * Klasa reprezentująca punkt
 */
public class Point{
    private int x;
    private int y;
    /**
     * Konstruktor tworzący punkt o podanych współrzędnych (x, y).
     * @param x współrzędna x punktu
     * @param y współrzędna y punktu
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Konstruktor tworzący punkt na podstawie innego punktu (orginalPoint).
     * @param orginalPoint punkt, na podstawie którego tworzony jest nowy punkt
     */
    public Point(Point orginalPoint) {
        this.x = orginalPoint.getX();
        this.y = orginalPoint.getY();
    }
    /**
     * Zwraca współrzędną x punktu.
     * @return współrzędna x punktu
     */
    public int getX() {
        return x;
    }
    /**
     * Zwraca współrzędną y punktu.
     * @return współrzędna y punktu
     */
    public int getY() {
        return y;
    }
    /**
     * Ustawia nową wartość współrzędnej x punktu.
     * @param x nowa wartość współrzędnej x
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Ustawia nową wartość współrzędnej y punktu.
     * @param y nowa wartość współrzędnej y
     */
    public void setY(int y) {
        this.y = y;
    }
    /**
     * Przesuwa punkt o wartości dx i dy.
     * @param dx wartość przesunięcia na osi x
     * @param dy wartość przesunięcia na osi y
     * @return przesunięty punkt
     */
    public Point translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
        return this;
    }
    /**
     * Przesuwa punkt na podstawie innego punktu (point).
     * @param point punkt, na podstawie którego następuje przesunięcie
     * @return przesunięty punkt
     */
    public Point translate(Point point) {
        this.x += point.getX();
        this.y += point.getY();
        return this;
    }
    /**
     * Sprawdza, czy punkt jest równy innemu punktowi (point).
     * @param point punkt, z którym porównywany jest bieżący punkt
     * @return true, jeśli punkty są równe, false w przeciwnym przypadku
     */
    public boolean equals(Point point) {
        return x == point.getX() && y == point.getY();
    }
    /**
     * Zwraca kierunek od bieżącego punktu do podanego punktu (targetPoint).
     * @param targetPoint punkt, do którego określany jest kierunek
     * @return kierunek od bieżącego punktu do podanego punktu
     */
    public Direction getDirection(Point targetPoint){
        Point nextPos = new Point( targetPoint);
        Point currentPos = new Point(this);
        nextPos = nextPos.translate(-currentPos.getX(),-currentPos.getY());
        return Direction.getDirection(nextPos);
    }
}
