import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Klasa Snake reprezentuje węża, który jest poruszającą się jednostką.
 * Implementuje interfejsy Collidable, Renderable, Movable, Playable.
 */
public class Snake extends MovingEntity implements Collidable, Renderable, Movable, Playable{
    private LinkedList<Entity> body;
    private int size;
    private Texture texture;
    private int score = 0;
    /**
     * Konstruktor klasy Snake.
     * @param x       pozycja x węża
     * @param y       pozycja y węża
     * @param _ID     identyfikator węża
     */
    public Snake(int x, int y, int _ID) {
        super(x, y, Direction.UP);
        size = 10;
        setID(_ID);
        setValues();
        body = new LinkedList<>();
    }
    /**
     * Konstruktor klasy Snake.
     * @param x            pozycja x węża
     * @param y            pozycja y węża
     * @param _ID          identyfikator węża
     * @param _direction   kierunek węża
     * @param _size        rozmiar węża
     */
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
    /**
     * Metoda increaseSize zwiększa rozmiar węża o 1 i zwiększa wynik gracza.
     */
    public void increaseSize() {
        size++;
        score++;
    }
    /**
     * Metoda getSize zwraca rozmiar węża.
     * @return rozmiar węża
     */
    public int getSize() {
        return size;
    }
    /**
     * Metoda getScore zwraca wynik gracza.
     * @return wynik gracza
     */
    public int getScore() {
        return score;
    }
    
    @Override
    public void move() {
        body.add(new Entity(new Point(getX(),getY()), color, ID, value));//color id value
        pos.translate(direction.getPoint());
        if(body.size()>size){
            body.removeFirst();
        }
    }
    
    @Override
    public boolean collidesWith(Entity entity){
        var entityPos = entity.getPos();
        if(entity != this)
            if (getPos().equals(entityPos)) {
                return true;
            }
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
        
        texture = TextureLoader.getTexture(getDirection());
        texture.updateImage(getPos());
        texture.render(g);
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
    
    @Override
    public void think() {
        Rotate(Rotation.FORWARD);
    }
}