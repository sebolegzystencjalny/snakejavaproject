//import java.util.Random;
//
//public class AISnake implements Runnable {
//    private final int[] aiSnakeX = new int[300];
//    private final int[] aiSnakeY = new int[300];
//    private int aiSnakeSize = 10;
//    private int aiDirection = 2; // 0-Up, 1-Right, 2-Down, 3-Left
//    private int loopCounter = 0;
//    private Random random = new Random();
//
//    public void initiateAISnake() {
//        for (int i = 0; i < aiSnakeSize; i++) {
//            aiSnakeX[i] = 200 - i * 10;
//            aiSnakeY[i] = 200;
//        }
//    }
//
//    public int getAISnakeSize() {
//        return aiSnakeSize;
//    }
//
//    public int[] getAISnakeX() {
//        return aiSnakeX;
//    }
//
//    public int[] getAISnakeY() {
//        return aiSnakeY;
//    }
//
//public void move() {
//    // Przesuwa pozycje ciała węża
//    for (int i = aiSnakeSize - 1; i > 0; i--) {
//        aiSnakeX[i] = aiSnakeX[(i - 1)];
//        aiSnakeY[i] = aiSnakeY[(i - 1)];
//    }
//
//    // Przesuwa głowę węża w zależności od kierunku
//    switch (aiDirection) {
//        case 0: // Up
//            if (aiSnakeY[0] - 10 < 0) { // Jeśli wąż jest na górnej krawędzi planszy
//                aiDirection = 1; // Zmiana kierunku na prawo
//            } else {
//                aiSnakeY[0] -= 10;
//            }
//            break;
//        case 1: // Right
//            if (aiSnakeX[0] + 10 >= GameBoard.BOARD_WIDTH) { // Jeśli wąż jest na prawej krawędzi planszy
//                aiDirection = 2; // Zmiana kierunku na dół
//            } else {
//                aiSnakeX[0] += 10;
//            }
//            break;
//        case 2: // Down
//            if (aiSnakeY[0] + 10 >= GameBoard.BOARD_HEIGHT) { // Jeśli wąż jest na dolnej krawędzi planszy
//                aiDirection = 3; // Zmiana kierunku na lewo
//            } else {
//                aiSnakeY[0] += 10;
//            }
//            break;
//        case 3: // Left
//            if (aiSnakeX[0] - 10 < 0) { // Jeśli wąż jest na lewej krawędzi planszy
//                aiDirection = 0; // Zmiana kierunku na górę
//            } else {
//                aiSnakeX[0] -= 10;
//            }
//            break;
//    }
//
//    loopCounter++;
//    if (loopCounter == 5) {
//        loopCounter = 0;
//        changeDirection();
//    }
//}
//
//
//    private void changeDirection() {
//        // Generowanie losowego kierunku
//        int newDirection = random.nextInt(4);
//        // int newDirection = getBestMove()
//        
//        // Sprawdzenie czy nowy kierunek nie jest przeciwny do obecnego
//        if (newDirection != (aiDirection + 2) % 4) {
//            aiDirection = newDirection;
//        }
//    }
//
//    public void increaseSize() {
//        aiSnakeSize++;
//    }
//    
//    @Override
//    public void run() {
//        while (true) {
//            move();
//            try {
//                // Czas oczekiwania w milisekundach pomiędzy ruchami węża AI
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
