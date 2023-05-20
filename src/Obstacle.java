import java.awt.Color;

public class Obstacle extends Entity implements Renderable, Collidable {
    public Obstacle(int x, int y) {
        super(x, y);
        setValues();
    }

    private void setValues(){
        color = Color.WHITE;
        value = -100;
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
    
}
