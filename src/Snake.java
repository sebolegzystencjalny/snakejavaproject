import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

public class Snake extends MovingEntity implements Collidable, Renderable, Movable{
    private LinkedList<Entity> body;
    private int size;

    public Snake(int x, int y, int _ID) {
        super(x, y, Direction.UP);
        size = 10;
        setID(_ID);
        setValues();
        body = new LinkedList<>();
    }
    
    public Snake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _direction);
        size = _size;
        setID(_ID);
        setValues();
        body = new LinkedList<>();
    }
    
    private void setValues(){
        color = Color.ORANGE;
        value = -100;
    }
    
    public void increaseSize() {
        size++;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public void move() {
        body.add(new Entity(new Point(getX(),getY()), color, ID, value));//color id value
        pos.translate(direction.getPoint());
        if(body.size()>size){
            body.removeFirst();
        }
        System.out.printf("size = %d, realsize = %d, position\n",size,body.size());
    } 
    
    @Override
    public boolean collidesWith(Entity entity){
        var entityPos = entity.getPos();
        for (Entity bodyPart : body) {
            if (bodyPart.getPos().equals(entityPos)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void render(java.awt.Graphics g) {
        g.setColor(color);
        g.fillRect(getX()*PIXEL_SIZE, getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        for (Entity bodyPart : body) {
            g.fillRect(bodyPart.getX()*PIXEL_SIZE, bodyPart.getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
        }
    }
    
    @Override
    public ArrayList<Point> locate() {
        ArrayList<Point> localization = new ArrayList<>();
        localization.add(pos);
        for (Entity bodyPart : body) {
            localization.add(bodyPart.getPos());
        }
        return localization;
    }
}