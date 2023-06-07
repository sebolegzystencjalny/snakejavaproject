import java.awt.Color;

/**
 * Klasa reprezentująca żabę w grze.
 */
public class Frog extends MovingEntity implements Collidable, Renderable, Movable, Edible {
    private boolean freezed = false;
    /**
     * Konstruktor klasy Frog.
     *
     * @param x           Wartość współrzędnej x.
     * @param y           Wartość współrzędnej y.
     * @param _direction  Kierunek poruszania się żaby.
     */    
    public Frog(int x, int y, Direction _direction) {
        super(x, y, _direction);
        setValues();
    }
    /**
     * Konstruktor klasy Frog.
     *
     * @param x Wartość współrzędnej x.
     * @param y Wartość współrzędnej y.
     */
    public Frog(int x, int y) {
        super(x, y,Direction.UP);
        setValues();
    }
    
    private void setValues(){
        color = Color.GREEN;
        value = 5;
    }
    /**
     * Wyłącza zamrożenie żaby.
     */
    public void unfreeze(){
        freezed = false;
    }
    /**
     * Włącza zamrożenie żaby.
     */
    public void freeze(){
        freezed = true;
    }
    
    @Override
    public void render(java.awt.Graphics g) {
        g.setColor(color);
        g.fillRect(getX()*PIXEL_SIZE, getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
    
    @Override
    public boolean collidesWith(Entity entity) {
        // Collision logic with another object
        return getPos().equals(entity.getPos());
    }

    @Override
    public void move() {
        if(!freezed){
            pos.translate(direction.getPoint());
        }
    } 

    @Override
    public void think() {
        Rotation[] rotations = Rotation.values();
        Rotation rotation;
        Direction nextDirection = direction;
        Point nextPosition = new Point(pos).translate(nextDirection.getPoint());
        int i = 2;
        unfreeze();
        while(0 > gameState.getValue(nextPosition)){
            rotation = rotations[i];
            nextDirection = direction.rotate(rotation);
            nextPosition = new Point(pos).translate(nextDirection.getPoint());
            direction = direction.rotate(Rotation.LEFT);
            i--;
            if(i<0){
                freeze();
                break;
            }
        }
    }

}
