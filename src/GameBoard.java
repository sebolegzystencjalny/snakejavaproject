import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public final class GameBoard extends JPanel implements ActionListener {

    static final int BOARD_WIDTH = 800;
    static final int BOARD_HEIGHT = 500;
    static final int PIXEL_SIZE = 10;
    static final int TOTAL_PIXELS = (BOARD_WIDTH * BOARD_HEIGHT) / (PIXEL_SIZE * PIXEL_SIZE);

    final Font font = new Font("TimesRoman", Font.BOLD, 20);

    Snake playerSnake = new Snake();
    AISnake aiSnake = new AISnake();
    int foodEaten;

    char playerDirection = 'R';
    boolean inGame = false;
    final Timer timer = new Timer(150, this);

    Food food;

    public GameBoard() {
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.DARK_GRAY);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (inGame) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_LEFT:
                            if (playerDirection != 'R') {
                                playerDirection = 'L';
                            }
                            break;
                        case KeyEvent.VK_RIGHT:
                            if (playerDirection != 'L') {
                                playerDirection = 'R';
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (playerDirection != 'D') {
                                playerDirection = 'U';
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (playerDirection != 'U') {
                                playerDirection = 'D';
                            }
                            break;
                    }
                } else {
                    initiateGame();
                }
            }
        });

        initiateGame();
    }

protected void initiateGame() {
    playerSnake.initiateSnake();
    aiSnake.initiateAISnake();
    foodEaten = 0;
    playerDirection = 'R';
    inGame = true;
    spawnFood();
    timer.start();

    // Tworzenie i uruchomienie wątku dla AISnake
    Thread aiThread = new Thread(aiSnake);
    aiThread.start();
}


    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        if (inGame) {
            g.setColor(Color.RED);
            g.fillOval(food.getPosX(), food.getPosY(), PIXEL_SIZE, PIXEL_SIZE);

            g.setColor(Color.GREEN);
            for (int i = 0; i < playerSnake.getSnakeSize(); i++) {
                g.fillRect(playerSnake.getSnakeX()[i], playerSnake.getSnakeY()[i], PIXEL_SIZE, PIXEL_SIZE);
            }

            g.setColor(Color.BLUE);
            for (int i = 0; i < aiSnake.getAISnakeSize(); i++) {
                g.fillRect(aiSnake.getAISnakeX()[i], aiSnake.getAISnakeY()[i], PIXEL_SIZE, PIXEL_SIZE);
            }
        } else {
            String scoreText = String.format("Game Over... Score: %d... Press any key to play again!", foodEaten);
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(scoreText, (BOARD_WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, BOARD_HEIGHT / 2);
        }
    }

    protected void move() {
        playerSnake.move(playerDirection);
        aiSnake.move();
        }

    protected void spawnFood() {
        food = new Food();
    }

    protected void eatFood() {
        if ((playerSnake.getSnakeX()[0] == food.getPosX()) && (playerSnake.getSnakeY()[0] == food.getPosY())) {
            playerSnake.increaseSize();
            foodEaten++;
            spawnFood();
        }

        if ((aiSnake.getAISnakeX()[0] == food.getPosX()) && (aiSnake.getAISnakeY()[0] == food.getPosY())) {
            aiSnake.increaseSize();
            spawnFood();
        }
    }

protected void collisionTest() {
    int headX = playerSnake.getSnakeX()[0];
    int headY = playerSnake.getSnakeY()[0];

    // Sprawdź czy głowa węża gracza dotknęła krawędzi planszy
    if (headX >= BOARD_WIDTH || headX < 0 || headY >= BOARD_HEIGHT || headY < 0) {
        inGame = false;
    }
//
    // Sprawdź czy głowa węża AI dotknęła krawędzi planszy
    if (aiSnake.getAISnakeX()[0] >= BOARD_WIDTH || aiSnake.getAISnakeX()[0] < 0 || aiSnake.getAISnakeY()[0] >= BOARD_HEIGHT || aiSnake.getAISnakeY()[0] < 0) {
        inGame = false;
    }
//
    // Sprawdź kolizję z ciałem węża gracza 
    for (int i = playerSnake.getSnakeSize() - 1; i > 0; i--) {
        if ((playerSnake.getSnakeX()[0] == playerSnake.getSnakeX()[i]) && (playerSnake.getSnakeY()[0] == playerSnake.getSnakeY()[i])) {
            System.out.println("Wąż gracza wjechał w siebie");
            inGame = false;
            break;
        }
    }
//    
    // Sprawdź kolizję z ciałem węża Ai
    for (int i = playerSnake.getSnakeSize() - 1; i > 0; i--) {
        if ((playerSnake.getSnakeX()[0] == playerSnake.getSnakeX()[i]) && (playerSnake.getSnakeY()[0] == playerSnake.getSnakeY()[i])) {
            System.out.println("Wąż Ai wjechał w siebie");
            inGame = false;
            break;
        }
    }
//
    // Sprawdź kolizję z głową węża AI
    for (int i = 0; i < aiSnake.getAISnakeSize(); i++) {
        if ((headX == aiSnake.getAISnakeX()[i]) && (headY == aiSnake.getAISnakeY()[i])) {
            System.out.println("Wąż Gracza wjechał w węża Ai");
            inGame = false;
            break;
        }
    }
//
    // Sprawdź kolizję z głową węża Gracz
    for (int i = 0; i < playerSnake.getSnakeSize(); i++) {
        if ((aiSnake.getAISnakeX()[0] == playerSnake.getSnakeX()[i] ) && (aiSnake.getAISnakeY()[0] == playerSnake.getSnakeY()[i])) {
            System.out.println("Wąż Ai wjechał w węża Gracza");
            inGame = false;
            break;
        }
    }
//
    if (!inGame) {
        timer.stop();
    }
}


    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            collisionTest();
            eatFood();
        }

        repaint();
    }
}
