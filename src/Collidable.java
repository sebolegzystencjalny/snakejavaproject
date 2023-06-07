import java.util.ArrayList;

/**
 * Interfejs reprezentujący obiekty mogące kolidować z innymi obiektami.
 */
public interface Collidable {
    /**
     * Sprawdza, czy dany obiekt koliduje z innym obiektem.
     *
     * @param otherObject Obiekt, z którym sprawdzana jest kolizja.
     * @return True, jeśli obiekty kolidują; False w przeciwnym razie.
     */
    
    boolean collidesWith(Entity otherObject);
    
    /**
     * Zwraca listę punktów reprezentujących położenie obiektu.
     *
     * @return Lista punktów reprezentujących położenie obiektu.
     */
    ArrayList<Point> locate();
}


