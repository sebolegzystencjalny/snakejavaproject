public abstract class MovingEntity extends Entity implements Runnable{
    protected Direction direction;
    protected GameState gameState;
    
    public MovingEntity(){
        super(0,0);
        direction = Direction.UP;
    }
    
    public MovingEntity(int x, int y, Direction _direction){
        super(x,y);
        direction = _direction;
    }
    
    public void setGameState(GameState _gameState){
        gameState = _gameState;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
    public void Rotate(Rotation rotation){
        direction = direction.rotate(rotation);
    }
    
    @Override
    public void run(){
        think();
        move();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        
    public abstract void move();
    public abstract void think();
    
    
}
