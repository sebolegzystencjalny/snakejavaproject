import java.util.ArrayList;

public interface Collidable {
    boolean collidesWith(Entity otherObject);
    ArrayList<Point> locate();
}


