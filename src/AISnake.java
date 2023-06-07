import java.util.LinkedList;
/**
 * Klasa reprezentująca sztuczną inteligencję sterującą wężem.
 */
public class AISnake extends Snake implements Movable {
    private LinkedList<Point> Patch = new LinkedList<>();
    private int[][] map;
    private Point target;
    
    /**
     * Konstruktor klasy AISnake.
     * @param x    Początkowa pozycja węża - współrzędna x.
     * @param y    Początkowa pozycja węża - współrzędna y.
     * @param _ID  ID węża.
     */
     public AISnake(int x, int y, int _ID) {
        super(x, y, _ID);
        target = new Point(0,0);
    }
    /**
     * Konstruktor klasy AISnake.
     * @param x            Początkowa pozycja węża - współrzędna x.
     * @param y            Początkowa pozycja węża - współrzędna y.
     * @param _ID          ID węża.
     * @param _direction   Początkowy kierunek poruszania się węża.
     * @param _size        Początkowy rozmiar węża.
     */
    public AISnake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _ID, _direction, _size);
        target = new Point(0,0);
    }
    
    @Override
    public void think(){
        map = gameState.getPreparedMap(pos);
        
        if(!patchClear() || !targetExist() || Patch.isEmpty()){
            target = findTarget();
            Patch = (LinkedList) BFSAlgorithm.findPath(map, new Point(getPos()));
//            Patch = (LinkedList) BFSAlgorithm.findPath(map, new Point(getPos()), target);
            survive();

        }
          
            followPatch();
            survive();
    }
    /**
     * 
     * Wykonuje działania mające na celu przetrwanie w przypadku braku dostępnej ścieżki.
     *
     * @param gameState Obiekt reprezentujący stan gry.
     */
    private void survive() {
        Rotation[] rotations = Rotation.values();
        Rotation rotation = rotations[0];
        Direction nextDirection = direction;
        Point nextPosition = new Point(pos).translate(nextDirection.getPoint());
        int i = 2;
        while(0 > gameState.getValue(nextPosition)&& i > 0){
//            System.out.print("HELP");
            rotation = rotations[i];
            nextDirection = direction.rotate(rotation);
            nextPosition = new Point(pos).translate(nextDirection.getPoint());
            direction = direction.rotate(Rotation.LEFT);
            i--;
        }
    }
    
    /**
     * Sprawdza, czy ścieżka jest wolna od przeszkód.
     *
     * @return True, jeśli ścieżka jest wolna od przeszkód; False w przeciwnym razie.
     */
    private boolean patchClear() {
        if(Patch.isEmpty())
            return false;
        for(Point point : Patch){
            if(map[point.getX()][point.getY()] < 0)
                return false;
        }
        return true;
    }
    
    /**
     * Sprawdza, czy istnieje cel na ścieżce.
     *
     * @return True, jeśli cel istnieje na ścieżce; False w przeciwnym razie.
     */
    private boolean targetExist() {
        if(Patch.isEmpty())
            return false;
        return map[target.getX()][target.getY()] > 0;
    }
    
    /**
     * Znajduje pozycję celu na mapie.
     *
     * @return Pozycja celu.
     */
    private Point findTarget() {
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[0].length; j++)
                if(map[i][j] > 0)
                    return new Point(i,j);
        return new Point(0,0);
    }
    
    /**
     * Przemieszcza się wzdłuż ścieżki.
     */
    private void followPatch() {
        if(!Patch.isEmpty()){
            Patch.removeFirst();
            if(!Patch.isEmpty()){
                Point tmp = new Point(Patch.getFirst());
                direction = pos.getDirection(tmp);
            }
        }
    }
}

