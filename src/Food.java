import java.util.Random;

public class Food {
    private final int posX;
    private final int posY;

    public Food() {
        posX = generatePos(GameBoard.BOARD_WIDTH);
        posY = generatePos(GameBoard.BOARD_HEIGHT);
    }

    private int generatePos(int size) {
        Random random = new Random();
        return random.nextInt(size / GameBoard.PIXEL_SIZE) * GameBoard.PIXEL_SIZE;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
