/**

Abstrakcyjna klasa reprezentująca poruszające się obiekty w grze.

Rozszerza klasę Entity i implementuje interfejs Runnable.
*/
public abstract class MovingEntity extends Entity implements Runnable{
    protected Direction direction;
    protected GameState gameState;
    private Object mutex = new Object(); // Mutex
    /**

    Konstruktor bezargumentowy klasy MovingEntity.
    Ustawia domyślny kierunek poruszania się na górę.
    */
    public MovingEntity(){
        super(0,0);
        direction = Direction.UP;
    }
    /**

    Konstruktor klasy MovingEntity.
    @param x współrzędna x pozycji początkowej obiektu
    @param y współrzędna y pozycji początkowej obiektu
    @param _direction początkowy kierunek poruszania się obiektu
    */
    public MovingEntity(int x, int y, Direction _direction){
        super(x,y);
        direction = _direction;
    }
    /**

    Ustawia stan gry dla obiektu.
    @param _gameState stan gry
    */
    public void setGameState(GameState _gameState){
        gameState = _gameState;
    }
    /**    
    Ustawia mutex dla obiektu.
    @param _mutex mutex
    */
    public void setMutex(Object _mutex){
        mutex = mutex;
    }
    /**

    Zwraca kierunek poruszania się obiektu.
    @return kierunek poruszania się
    */
    public Direction getDirection(){
        return direction;
    }
    /**

    Obraca obiekt wokół własnej osi zgodnie z podaną rotacją.
    @param rotation rotacja do zastosowania
    */
    public void Rotate(Rotation rotation){
        direction = direction.rotate(rotation);
    }
    /**

    Metoda wywoływana w osobnym wątku.
    Wykonuje logikę poruszania się i myślenia obiektu.
    */
    @Override
    public void run(){
        synchronized (mutex) {
            think();
            move();
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**

    Abstrakcyjna metoda odpowiedzialna za poruszanie się obiektu.
    */
    public abstract void move();
    
    /**
    Abstrakcyjna metoda odpowiedzialna za podejmowanie decyzji przez obiekt.
    */
    public abstract void think();
    
    
}
