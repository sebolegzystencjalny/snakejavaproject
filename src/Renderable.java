import java.awt.*;
/**
 * Interfejs Renderable reprezentuje obiekt, który może być renderowany graficznie.
 */
public interface Renderable {
    /**
     * Stała PIXEL_SIZE określa rozmiar piksela, który jest używany do renderowania.
     */
    static final int PIXEL_SIZE = 10;
    /**
     * Metoda render służy do renderowania obiektu przy użyciu grafiki (g).
     * @param g obiekt Graphics, który jest używany do renderowania
     */
    void render(Graphics g);
}