
import java.awt.Point;

public class Entity {
    protected Point pos;

    public Entity(){
        pos = new Point(0,0);
    }
    public Entity(int _X, int _Y) {
        pos = new Point(_X, _Y);
    }

    public int getPosX() {
        return (int)pos.getX();
    }

    public int getPosY() {
        return (int)pos.getY();
    }
    
    public Point getPos() {
        return pos;
    }
}