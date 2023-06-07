import java.awt.Color;
import java.util.ArrayList;

/**
 * Klasa reprezentująca podstawową jednostkę w grze.
 */
public class Entity implements Renderable, Collidable{
    protected Point pos;
    protected Color color;
    protected int ID;
    protected int value;

    /**
     * Klasa reprezentująca podstawową jednostkę w grze.
     */
    public Entity(){
        pos = new Point(0,0);
    }
    /**
     * Konstruktor klasy Entity.
     *
     * @param _X Wartość współrzędnej x.
     * @param _Y Wartość współrzędnej y.
     */
    public Entity(int _X, int _Y) {
        pos = new Point(_X, _Y);
    } 
    /**
     * Konstruktor klasy Entity.
     *
     * @param _X     Wartość współrzędnej x.
     * @param _Y     Wartość współrzędnej y.
     * @param _color Kolor obiektu.
     * @param _ID    ID obiektu.
     */
    public Entity(int _X, int _Y, Color _color, int _ID) {
        pos = new Point(_X, _Y);
        color = _color;
        ID = _ID;
    }
    /**
     * Konstruktor klasy Entity.
     *
     * @param _X     Wartość współrzędnej x.
     * @param _Y     Wartość współrzędnej y.
     * @param _color Kolor obiektu.
     * @param _ID    ID obiektu.
     * @param _value Wartość obiektu.
     */
    public Entity(int _X, int _Y, Color _color, int _ID, int _value) {
        pos = new Point(_X, _Y);
        color = _color;
        ID = _ID;
        value = _value;
    } 
    /**
     * Konstruktor klasy Entity.
     *
     * @param point Punkt reprezentujący pozycję obiektu.
     */
    public Entity(Point point) {
        pos = point;
    } 
    /**
     * Konstruktor klasy Entity.
     *
     * @param point  Punkt reprezentujący pozycję obiektu.
     * @param _color Kolor obiektu.
     * @param _ID    ID obiektu.
     * @param _value Wartość obiektu.
     */
    public Entity(Point point, Color _color, int _ID, int _value) {
        pos = point;
        color = _color;
        ID = _ID;
        value = _value;
    } 
    /**
     * Ustawia wartość obiektu.
     *
     * @param _value Wartość obiektu.
     */
    public void setValue(int _value){
        ID = _value;
    }
    /**
     * Zwraca wartość obiektu.
     *
     * @return Wartość obiektu.
     */
    public int getValue(){
        return value;
    }
    /**
     * Ustawia ID obiektu.
     *
     * @param _ID ID obiektu.
     */
    public void setID(int _ID){
        this.ID = _ID;
    }
    /**
     * Zwraca ID obiektu.
     *
     * @return ID obiektu.
     */
    public int getID(){
        return ID;
    }
    /**
     * Ustawia kolor obiektu.
     *
     * @param _color Kolor obiektu.
     */
    public void setColor(Color _color){
        this.color = _color;
    }
    /**
     * Zwraca kolor obiektu.
     *
     * @return Kolor obiektu.
     */
    public Color getColor(){
        return color;
    }
    /**
     * Zwraca wartość współrzędnej x.
     *
     * @return Wartość współrzędnej x.
     */
    public int getX() {
        return (int)pos.getX();
    }
    /**
     * Zwraca wartość współrzędnej y.
     *
     * @return Wartość współrzędnej y.
     */
    public int getY() {
        return (int)pos.getY();
    }
    /**
     * Zwraca pozycję obiektu.
     *
     * @return Pozycja obiektu.
     */
    public Point getPos() {
        return pos;
    }
    /**
     * Ustawia pozycję obiektu.
     *
     * @param _pos Nowa pozycja obiektu.
     */
    public void setPos(Point _pos) {
        this.pos = _pos;
    }
    /**
     * Ustawia wartość współrzędnej x.
     *
     * @param _X Nowa wartość współrzędnej x.
     */
    public void setX(int _X) {
        pos = new Point(_X, getY());
    }    
    /**
     * Ustawia wartość współrzędnej y.
     *
     * @param _Y Nowa wartość współrzędnej y.
     */
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
