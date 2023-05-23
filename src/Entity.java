import java.awt.Color;
import java.util.ArrayList;

public class Entity implements Renderable, Collidable{
    protected Point pos;
    protected Color color;
    protected int ID;
    protected int value;

    public Entity(){
        pos = new Point(0,0);
    }
    public Entity(int _X, int _Y) {
        pos = new Point(_X, _Y);
    } 
    
    public Entity(int _X, int _Y, Color _color, int _ID) {
        pos = new Point(_X, _Y);
        color = _color;
        ID = _ID;
    }
    
    public Entity(int _X, int _Y, Color _color, int _ID, int _value) {
        pos = new Point(_X, _Y);
        color = _color;
        ID = _ID;
        value = _value;
    } 
    
    public Entity(Point point) {
        pos = point;
    } 
    
    public Entity(Point point, Color _color, int _ID, int _value) {
        pos = point;
        color = _color;
        ID = _ID;
        value = _value;
    } 
        
    public void setValue(int _value){
        ID = _value;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setID(int _ID){
        ID = _ID;
    }
    
    public int getID(){
        return ID;
    }
    
    public void setColor(Color _color){
        color = _color;
    }
    
    public Color getColor(){
        return color;
    }

    public int getX() {
        return (int)pos.getX();
    }

    public int getY() {
        return (int)pos.getY();
    }
    
    public Point getPos() {
        return pos;
    }
    
    public void setPos(Point _pos) {
        pos = _pos;
    }
    
    public void setX(int _X) {
        pos = new Point(_X, getY());
    }    
        
    public void setY(int _Y) {
        pos = new Point(getX(),_Y);
    } 
    
    @Override
    public void render(java.awt.Graphics g) {
        g.setColor(color);
        g.fillRect(getX()*PIXEL_SIZE, getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
    
    @Override
    public ArrayList<Point> locate() {
        ArrayList<Point> localization = new ArrayList<>();
        localization.add(pos);
        return localization;
    }

    @Override
    public boolean collidesWith(Entity otherObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
