import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class GameBoard extends JPanel implements ActionListener {

    static final int BOARD_WIDTH = 800;
    static final int BOARD_HEIGHT = 500;

    final Font font = new Font("TimesRoman", Font.BOLD, 20);
    
    GameState gameState = new GameState(80,50);
    
    ArrayList<Movable> listOfMovables = new ArrayList<>();
    ArrayList<Renderable> listOfRenderables = new ArrayList<>();
    ArrayList<Collidable> listOfCollidables = new ArrayList<>();
    ArrayList<Obstacle> listOfObstacles = new ArrayList<>();
    
    Snake playerSnake;
    
    boolean inGame = false;
    
    final Timer timer = new Timer(150, this);

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
                            gameState.setRotation(Rotation.LEFT);
                            break;
                        case KeyEvent.VK_RIGHT:
                            gameState.setRotation(Rotation.RIGHT);
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
    
    playerSnake = new Snake(5,5,5);
    listOfRenderables.add(playerSnake);
    listOfRenderables.add(new Food(50,20));
    listOfRenderables.add(new Frog(12,9));
    
    ArrayList<Obstacle> tmpObstacles = ObstacleGenerator.generateHollowRectangle(80, 50,0,0);
    listOfObstacles.addAll(tmpObstacles);
    
    for (Obstacle obstacle : listOfObstacles) {
        Renderable renderable = (Renderable) obstacle;
        listOfRenderables.add(renderable);
    }
    
    for (Renderable renderable : listOfRenderables) {
        // Check if the object is an instance of Renderable
        if (renderable instanceof Movable) {
            Movable movable = (Movable) renderable;
            listOfMovables.add(movable);
        }
    }
        
    for (Renderable renderable : listOfRenderables) {
        // Check if the object is an instance of Renderable
        if (renderable instanceof Collidable) {
            Collidable collidable = (Collidable) renderable;
            listOfCollidables.add(collidable);
        }
    }
    
    inGame = true;
    timer.start();
}


    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            for (Renderable entity : listOfRenderables) {
                entity.render(g);
            }
        } else {
            String scoreText = String.format("Game Over... Score: %d... Press any key to play again!");
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(scoreText, (BOARD_WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, BOARD_HEIGHT / 2);
        }
    }

    protected void move() {
        for (Movable movable : listOfMovables) {
            movable.think(gameState);
            movable.move();
            System.out.print(((Entity)movable).getID());
        }
    }
    
    protected void collisionTest() {
//        for (Collidable  : listOfMovables) {
//            movable.move();
//        }
    }
    
    private void observe() {
        gameState.ereaseMap();
        for (Collidable collidable : listOfCollidables) {
            gameState.locateEntities(collidable.locate(),((Entity)collidable).getValue());
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
            }
            observe();
            move();
            //collisionTest();
        }
        repaint();
    }
}
