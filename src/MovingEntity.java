public class MovingEntity extends Entity{
    protected Direction direction;
    
    public MovingEntity(){
        super(0,0);
        direction = Direction.UP;
    }
    
    public MovingEntity(int x, int y, Direction _direction){
        super(x,y);
        direction = _direction;
    }
    
    public Direction getDirection(){
        return direction;
    }
    
    public void Rotate(Rotation rotation){
        direction = direction.rotate(rotation);
    }
}
