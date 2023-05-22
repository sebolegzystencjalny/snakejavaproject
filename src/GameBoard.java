import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
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
    ArrayList<Playable> listOfPlayables = new ArrayList<>();
    ArrayList<Edible> listOfEdibles = new ArrayList<>();
    
    Snake playerSnake;
    Food apple;
    boolean inGame = false;
    
    final Timer timer = new Timer(150, this);

    public GameBoard() {
        TextureLoader.loadTextures();
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
    
    playerSnake = new AISnake(40,40,5);
    apple = new Food(10,13); 
    
    listOfPlayables.add(playerSnake);
    listOfEdibles.add(apple);
    listOfPlayables.add(  new AISnake(50,40,5));
    listOfPlayables.add(  new AISnake(10,40,5));
    listOfPlayables.add(  new AISnake(20,40,5));
    listOfPlayables.add(  new AISnake(30,40,5));
    listOfEdibles.add(new Frog(12,9));
    
    ArrayList<Obstacle> tmpObstacles = ObstacleGenerator.generateHollowRectangle(80, 50,0,0);
    listOfObstacles.addAll(tmpObstacles);
    
    for (Edible edible : listOfEdibles) {
        Renderable renderable = (Renderable) edible;
        listOfRenderables.add(renderable);
    }
    
    for (Playable playable : listOfPlayables) {
        Renderable renderable = (Renderable) playable;
        listOfRenderables.add(renderable);
    }
    
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
//            System.out.print(((Entity)movable).getID());
        }
    }
    
    protected void collisionTest() {
//        for (Collidable collidable : listOfCollidables) {
////            if(collidable.collidesWith(playerSnake)){
////                playerSnake.setX(40);
////                playerSnake.setY(40);
////                System.out.print("boom");
////            }
//            Random random = new Random();
//            int randomX = 1 + random.nextInt(78);
//            int randomY = 1 + random.nextInt(48);
//            
//            if(playerSnake.collidesWith(apple)){
//                apple.setX(randomX);
//                apple.setY(randomY);
//                playerSnake.increaseSize();
//                System.out.print("omnomnom");
//            }
//        }
        for (Playable playable : listOfPlayables) {
            for (Edible edible : listOfEdibles) {
                Random random = new Random();
                int randomX = 1 + random.nextInt(78);
                int randomY = 1 + random.nextInt(48);

                if(((Collidable)edible).collidesWith((Entity)playable)){
                    apple.setX(randomX);
                    apple.setY(randomY);
                    ((Snake)playable).increaseSize();
                    System.out.print("omnomnom");
                }
            }
        }
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
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(GameBoard.class.getName()).log(Level.SEVERE, null, ex);
//            }
            observe();
            move();
            collisionTest();
        }
        repaint();
    }
}
