import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Klasa Texture reprezentuje teksturę, która może być wyświetlana na ekranie.
 * Składa się ona z obrazu reprezentowanego przez dwuwymiarową tablicę znaków oraz pozycji na ekranie.
 */
public class Texture implements Renderable{
    char[][] image = new char[PIXEL_SIZE][PIXEL_SIZE];
    Point pos;
    /**
     * Konstruktor tworzy pusty obiekt Texture z domyślnymi wartościami.
     */
    public Texture() {
        for (int row = 0; row < PIXEL_SIZE; row++) {
            for (int col = 0; col < PIXEL_SIZE; col++) {
                image[row][col] = 0;
            }
        }
    }
    /**
     * Konstruktor tworzy obiekt Texture, odczytując obraz z pliku.
     * Plik obrazu powinien zawierać prostokątną siatkę znaków reprezentujących piksele.
     *
     * @param filePath ścieżka do pliku obrazu
     */
    public Texture(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            for (int row = 0; row < PIXEL_SIZE; row++) {
                String line = scanner.nextLine();
                for (int col = 0; col < PIXEL_SIZE; col++) {
                    image[row][col] = line.charAt(col);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Konstruktor tworzy obiekt Texture, odczytując obraz z pliku i określając jego pozycję na ekranie.
     * Plik obrazu powinien zawierać prostokątną siatkę znaków reprezentujących piksele.
     *
     * @param filePath ścieżka do pliku obrazu
     * @param _pos     pozycja tekstury na ekranie
     */
    public Texture(String filePath, Point _pos) {
        pos = _pos;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            for (int row = 0; row < PIXEL_SIZE; row++) {
                String line = scanner.nextLine();
                for (int col = 0; col < PIXEL_SIZE; col++) {
                    image[row][col] = line.charAt(col);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Konstruktor tworzy obiekt Texture, odczytując obraz z pliku i określając jego pozycję oraz kierunek na ekranie.
     * Plik obrazu powinien zawierać prostokątną siatkę znaków reprezentujących piksele.
     *
     * @param filePath     ścieżka do pliku obrazu
     * @param _direction   kierunek tekstury
     * @param _pos         pozycja tekstury na ekranie
     */
    public Texture(String filePath, Direction _direction, Point _pos) {
        pos = _pos;
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            for (int row = 0; row < PIXEL_SIZE; row++) {
                String line = scanner.nextLine();
                for (int col = 0; col < PIXEL_SIZE; col++) {
                    image[row][col] = line.charAt(col);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private Color getColorFromPixel(char pixel) {
        switch (pixel) {
            case 'r':
                return Color.RED;
            case 'b':
                return Color.BLACK;
            case 'w':
                return Color.WHITE;
            default:
                return Color.GRAY;
        }
    }
    @Override
    public void render(Graphics g) {
        int x = pos.getX() * PIXEL_SIZE;
        int y = pos.getY() * PIXEL_SIZE;
        for (int row = 0; row < PIXEL_SIZE; row++) {
            for (int col = 0; col < PIXEL_SIZE; col++) {
                char pixel = image[row][col];
                Color color = getColorFromPixel(pixel);
                if (color != Color.GRAY){
                    g.setColor(color);
                    g.fillRect(x + row, y + col, 1, 1);
                }
            }
        }
    }
    
    /**
     * Aktualizuje pozycję tekstury.
     *
     * @param _pos nowa pozycja tekstury
     */
    public void updateImage(Point _pos){
        pos = _pos;
    }
}