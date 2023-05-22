import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Texture implements Renderable{
    char[][] image = new char[PIXEL_SIZE][PIXEL_SIZE];
    Point pos;
    
    public Texture() {
        for (int row = 0; row < PIXEL_SIZE; row++) {
            for (int col = 0; col < PIXEL_SIZE; col++) {
                image[row][col] = 0;
            }
        }
    }
    
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
    
    public void updateImage(Point _pos){
        pos = _pos;
    }
}