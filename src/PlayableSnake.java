import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;

public class PlayableSnake extends Snake implements Movable{
    private int keyLeft = KeyEvent.VK_LEFT;
    private int keyRight = KeyEvent.VK_RIGHT;
    
    public PlayableSnake(int x, int y, int _ID) {
        super(x, y, _ID);
    }
    
    public PlayableSnake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _ID, _direction, _size);
    }
    
    public void setKeyLeft(int newKey){
        this.keyLeft = newKey;
    }
    
    public void setKeyRight(int newKey){
        this.keyRight = newKey;
    }
    
    public int getKeyLeft(){
        return keyLeft;
    }
    
    public int getKeyRight(){
        return keyRight;
    }
    
    @Override
    public void think(GameState gameState) {
        ArrayList<Integer> input = gameState.getInputed();
        for (int key : input){
            if(key == keyLeft){
                Rotate(Rotation.LEFT);
                break;
            }
            if(key == keyRight){
                Rotate(Rotation.RIGHT);
                break;
            }
        }
    }
}
