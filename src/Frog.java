import java.awt.Color;
import java.util.Random;

public class Frog extends MovingEntity implements Collidable, Renderable, Movable {
    private boolean freezed = false;
            
    public Frog(int x, int y, Direction _direction) {
        super(x, y, _direction);
        setValues();
    }
    
    public Frog(int x, int y) {
        super(x, y,Direction.UP);
        setValues();
    }
    
    private void setValues(){
        color = Color.GREEN;
        value = 5;
    }
    
    public void freeze(){
        freezed = true;
    }
    
    @Override
    public void render(java.awt.Graphics g) {
        g.setColor(color);
        g.fillRect(getX()*PIXEL_SIZE, getY()*PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
    }
    
    @Override
    public boolean collidesWith(Entity entity) {
        // Collision logic with another object
        return getPos().equals(entity.getPos());
    }

    @Override
    public void move() {
        if(!freezed){
            pos.translate(direction.getPoint());
        }
    } 

    @Override
    public void think(GameState gameState) {
        Direction[] directions = Direction.values();
        Random random = new Random();
        int randomIndex = random.nextInt(4);
        direction = directions[randomIndex];
        int i = 4;
        while(0 > gameState.getValue(getPos().translate(direction.getPoint()))){
            direction = direction.rotate(Rotation.LEFT);
//            System.out.printf("%d, %d , %d\n",i, direction.getPoint().getX(), direction.getPoint().getY());
            i--;
            if(i<0){
                freeze();
                break;
            }
        }
    }
}
