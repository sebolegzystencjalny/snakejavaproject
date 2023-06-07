import java.awt.Color;

/**
 * Klasa reprezentująca jedzenie w grze.
 */
public class Food extends Entity implements Renderable, Collidable, Edible {
    public Food(int x, int y) {
        super(x, y);
        setValues();
    }
    /**
     * Konstruktor klasy Food.
     *
     * @param x Wartość współrzędnej x.
     * @param y Wartość współrzędnej y.
     */
    private void setValues(){
        color = Color.RED;
        value = 1;
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
}
