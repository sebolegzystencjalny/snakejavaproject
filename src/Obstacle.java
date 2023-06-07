import java.awt.Color;
/**
 * Klasa reprezentująca przeszkodę w grze.
 * Rozszerza klasę Entity i implementuje interfejsy Renderable i Collidable.
 */
public class Obstacle extends Entity implements Renderable, Collidable {
    /**
     * Konstruktor klasy Obstacle.
     * @param x współrzędna x pozycji przeszkody
     * @param y współrzędna y pozycji przeszkody
     */
    public Obstacle(int x, int y) {
        super(x, y);
        setValues();
    }

    private void setValues(){
        color = Color.WHITE;
        value = -10;
    }
    /**
     * Metoda renderująca przeszkodę na ekranie.
     * @param g obiekt Graphics do rysowania
     */
    @Override
    public void render(java.awt.Graphics g) {
        g.setColor(color);
        g.fillRect(getX()*PIXEL_SIZE, getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
    /**
     * Metoda sprawdzająca kolizję z innym obiektem.
     * @param entity obiekt do sprawdzenia kolizji
     * @return true, jeśli występuje kolizja, false w przeciwnym razie
     */
    @Override
    public boolean collidesWith(Entity entity) {
        // Collision logic with another object
        return getPos().equals(entity.getPos());
    }
    
}
