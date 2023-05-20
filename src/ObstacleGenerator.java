import java.util.ArrayList;
import java.util.List;

public class ObstacleGenerator {
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
