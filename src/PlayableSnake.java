import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Klasa reprezentująca sterowalnego węża.
 */
public class PlayableSnake extends Snake implements Movable{
    private int keyLeft = KeyEvent.VK_LEFT;
    private int keyRight = KeyEvent.VK_RIGHT;
    /**
     * Konstruktor tworzący sterowalnego węża na podanej pozycji (x, y) i o danym identyfikatorze.
     * @param x współrzędna x pozycji węża
     * @param y współrzędna y pozycji węża
     * @param _ID identyfikator węża
     */
    public PlayableSnake(int x, int y, int _ID) {
        super(x, y, _ID);
    }
    /**
     * Konstruktor tworzący sterowalnego węża na podanej pozycji (x, y) o danym identyfikatorze, kierunku i rozmiarze.
     * @param x współrzędna x pozycji węża
     * @param y współrzędna y pozycji węża
     * @param _ID identyfikator węża
     * @param _direction kierunek poruszania się węża
     * @param _size rozmiar węża
     */
    public PlayableSnake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _ID, _direction, _size);
    }
    /**
     * Ustawia klawisz odpowiedzialny za skręt w lewo.
     * @param newKey klawisz reprezentujący skręt w lewo
     */
    public void setKeyLeft(int newKey){
        this.keyLeft = newKey;
    }
    /**
     * Ustawia klawisz odpowiedzialny za skręt w prawo.
     * @param newKey klawisz reprezentujący skręt w prawo
     */
    public void setKeyRight(int newKey){
        this.keyRight = newKey;
    }
    /**
     * Zwraca klawisz odpowiedzialny za skręt w lewo.
     * @return klawisz reprezentujący skręt w lewo
     */
    public int getKeyLeft(){
        return keyLeft;
    }
    /**
     * Zwraca klawisz odpowiedzialny za skręt w prawo.
     * @return klawisz reprezentujący skręt w prawo
     */
    public int getKeyRight(){
        return keyRight;
    }
    
    @Override
    public void think() {
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
