import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;


public final class GameBoard extends JPanel implements ActionListener {

    static final int BOARD_WIDTH = 800;
    static final int BOARD_HEIGHT = 500;
    private int ID;
    final Font font = new Font("TimesRoman", Font.BOLD, 20);
    
    GameState gameState = new GameState(80,50);
    
    ArrayList<Movable> listOfMovables = new ArrayList<>();
    ArrayList<Renderable> listOfRenderables = new ArrayList<>();
    ArrayList<Collidable> listOfCollidables = new ArrayList<>();
    
    ArrayList<Obstacle> listOfObstacles = new ArrayList<>();
    ArrayList<Playable> listOfPlayables = new ArrayList<>();
    ArrayList<Edible> listOfEdibles = new ArrayList<>();
    
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
                    gameState.addInput(e.getKeyCode());
                } else {
                    initiateGame();
                }
            }
        });
        initiateGame();
    }

    protected void initiateGame() {
        ID = 0;
        inGame = false;
        timer.stop();
        
        listOfMovables = new ArrayList<>();
        listOfRenderables = new ArrayList<>();
        listOfCollidables = new ArrayList<>();
    
        listOfObstacles = new ArrayList<>();
        listOfPlayables = new ArrayList<>();
        listOfEdibles = new ArrayList<>();
    }
    
    protected void initiateGame(int snakes, int food, int frogs) {
        ID = 0;
        ArrayList<Color> values = new ArrayList<>(Arrays.asList(Color.ORANGE,Color.CYAN,Color.WHITE, Color.YELLOW, Color.RED, Color.GREEN, Color.MAGENTA, Color.BLUE));
        inintializeEntities(1,snakes-1,values,food,frogs);

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
            String scoreText = String.format("Game Over!");
            g.setColor(Color.BLACK);
            g.setFont(font);
            g.drawString(scoreText, (BOARD_WIDTH - getFontMetrics(g.getFont()).stringWidth(scoreText)) / 2, BOARD_HEIGHT / 2);
        }
    }
    private void incrementID(){
        ID++;
    }
    
    public void addEntity(Entity entity){
        observe();
        entity.setPos(gameState.randomFreeSpace());
        if (entity instanceof Movable) {
            listOfMovables.add((Movable)entity);
        }
        if (entity instanceof Playable) {
            listOfPlayables.add((Playable)entity); 
        }
        if (entity instanceof Edible) {
            listOfEdibles.add((Edible)entity);
        } 
        listOfRenderables.add((Renderable)entity);
        listOfCollidables.add((Collidable)entity);
        entity.setID(ID);
        incrementID();
    }
    
    public void removeEntity(Entity entity){
//        if (entity instanceof Movable) {
//            listOfMovables.remove((Movable)entity);
//        }
//        if (entity instanceof Edible) {
//            listOfEdibles.remove((Edible)entity);
//        } 
        if (entity instanceof Playable) {
            listOfPlayables.remove((Playable)entity); 
        }
//        if (entity instanceof Obstacle) {
//            listOfObstacles.remove((Obstacle)entity); 
//        }

        listOfCollidables.remove((Collidable)entity);
        listOfRenderables.remove((Renderable)entity);
    }
    
    public void inintializeEntities(int snakes, int aiSnakes, ArrayList<Color> color, int food, int frogs){
        ArrayList<Obstacle> tmpObstacles = ObstacleGenerator.generateHollowRectangle(80, 50,0,0);
        
        listOfObstacles.addAll(tmpObstacles);
        for (Obstacle obstacle : listOfObstacles) {
            Renderable renderable = (Renderable) obstacle;
            listOfRenderables.add(renderable);
            listOfCollidables.add((Collidable) obstacle);
        }
        for (int i = 0; i < snakes; i++){
            Entity entity = new PlayableSnake(1,40,ID);
            entity.setColor(color.get(i%color.size()));
            addEntity(entity);
        }
        
        for (int i = 0; i < aiSnakes; i++){
            Entity entity = new AISnake(i * 5,40,5);
            entity.setColor(color.get(i%color.size()));
            addEntity(entity);
        }
        
        for (int i = 0; i < food; i++){
            Entity entity =  new Food(10,13);
            addEntity(entity);
        }
        
        for (int i = 0; i < frogs; i++){
            Entity entity = new Frog(12,9);
            addEntity(entity);
        }
    }
    
    protected void move() {
        for (Movable movable : listOfMovables) {
            observe();
            movable.think(gameState);
            movable.move();
        }
        gameState.clearInput();
    }
    
    public void addInput(int key){
        gameState.addInput(key);
    }
    
    protected void collisionTest() {
        ArrayList<Playable> deadSnakes = new ArrayList<>();
        for (Playable playable : listOfPlayables) {
            for (Edible edible : listOfEdibles) {
                if(((Collidable)edible).collidesWith((Entity)playable)){
                    ((Entity)edible).setPos(gameState.randomFreeSpace());
                    ((Snake)playable).increaseSize();
                }
            }
            for (Collidable collidable : listOfCollidables) {
                if((collidable).collidesWith((Entity)playable)){
                    if(collidable instanceof Edible)
                        break;
                    deadSnakes.add(playable);
                }
            }
        }
        for (Playable playable : deadSnakes) {
            removeEntity((Entity)playable);
        }
    }
    
    private void observe() {
        gameState.ereaseMap();
        for (Collidable collidable : listOfCollidables) {
            gameState.locateEntities(collidable.locate(),((Entity)collidable).getValue());
        }
        if(listOfPlayables.isEmpty())
            inGame = false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            observe();
            collisionTest();
        }
        repaint();
    }
}
