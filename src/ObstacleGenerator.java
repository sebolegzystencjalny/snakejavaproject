import java.util.ArrayList;
/**
 * Klasa generująca przeszkody w postaci prostokąta z otworem po środku.
 */
public class ObstacleGenerator {
    /**
     * Metoda generująca przeszkody w postaci prostokąta z otworem po środku.
     * @param width szerokość prostokąta
     * @param height wysokość prostokąta
     * @param startX współrzędna x początku prostokąta
     * @param startY współrzędna y początku prostokąta
     * @return lista przeszkód w postaci prostokąta z otworem po środku
     */
    public static ArrayList<Obstacle> generateHollowRectangle(int width, int height, int startX, int startY) {
        ArrayList<Obstacle> rectanglePoints = new ArrayList<>();

        for (int y = startY; y < startY + height; y++) {
            for (int x = startX; x < startX + width; x++) {
                if (x == startX || x == startX + width - 1 || y == startY || y == startY + height - 1) {
                    Obstacle obstacle = new Obstacle(x,y);
                    rectanglePoints.add(obstacle);
                }
            }
        }

        return rectanglePoints;
    }
}
