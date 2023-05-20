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
    
    public Point translate(Point point) {
//        System.out.printf("%d, %d\n",point.getX(), point.getY());
//        System.out.printf("%d, %d\n",getX(), getY());
        this.x += point.getX();
        this.y += point.getY();
//        System.out.printf("%d, %d\n",getX(), getY());
        return this;
    }
    
    public boolean equals(Point point) {
        return x == point.getX() && y == point.getY();
    }
    
}
