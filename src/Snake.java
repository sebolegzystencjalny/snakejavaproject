import java.util.Arrays;
import java.util.Random;

public class Snake {

    private int[] snakeX;
    private int[] snakeY;
    private int snakeSize;

    public Snake() {
        initiateSnake();
    }

    public void initiateSnake() {
        snakeX = new int[GameBoard.TOTAL_PIXELS];
        snakeY = new int[GameBoard.TOTAL_PIXELS];
        snakeSize = 40;

        // Wygeneruj losową pozycję dla głowy węża
        int headX = generateRandomPosition(GameBoard.BOARD_WIDTH);
        int headY = generateRandomPosition(GameBoard.BOARD_HEIGHT);

        // Ustaw głowę węża
        snakeX[0] = headX;
        snakeY[0] = headY;

        // Wygeneruj pozycję dla reszty segmentów węża
        for (int i = 1; i < snakeSize; i++) {
            snakeX[i] = headX - i * GameBoard.PIXEL_SIZE;
            snakeY[i] = headY;
        }
    }

    public void move(char direction) {
        for (int i = snakeSize - 1; i > 0; i--) {
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        switch (direction) {
        case 'U':
            snakeY[0] -= GameBoard.PIXEL_SIZE;
            break;
        case 'D':
            snakeY[0] += GameBoard.PIXEL_SIZE;
            break;
        case 'L':
            snakeX[0] -= GameBoard.PIXEL_SIZE;
            break;
        case 'R':
            snakeX[0] += GameBoard.PIXEL_SIZE;
            break;
        }
    }       

    public void increaseSize() {
        snakeSize++;
    }

    public int[] getSnakeX() {
        return Arrays.copyOf(snakeX, snakeSize);
    }

    public int[] getSnakeY() {
        return Arrays.copyOf(snakeY, snakeSize);
    }

    public int getSnakeSize() {
        return snakeSize;
    }

    private int generateRandomPosition(int max) {
        Random random = new Random();
        return random.nextInt(max / GameBoard.PIXEL_SIZE) * GameBoard.PIXEL_SIZE;
    }
}

