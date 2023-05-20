public class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public void translate(Point point) {
        this.x = x + point.getX();
        this.y = y + point.getY();
    }
    
    public boolean equals(Point point) {
        return x == point.getX() && y == point.getY();
    }
    
}
