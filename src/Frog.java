import java.awt.Color;

public class Frog extends MovingEntity implements Collidable, Renderable, Movable {

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
        pos.translate(direction.getPoint());
    } 
}
