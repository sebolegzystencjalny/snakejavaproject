import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AISnake extends Snake implements Movable {
    private LinkedList<Point> Patch = new LinkedList<>();
    private int[][] map;
    private Point target;
    
     public AISnake(int x, int y, int _ID) {
        super(x, y, _ID);
        target = new Point(0,0);
    }
    
    public AISnake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _ID, _direction, _size);
        target = new Point(0,0);
    }
    
    @Override
    public void think(GameState _gameState){
        map = _gameState.getPreparedMap(pos);
        if(!patchClear() || !targetExist() || Patch.isEmpty()){
            target = findTarget();
            Patch = (LinkedList) BFSAlgorithm.findPath(map, new Point(getPos()), target);
            if(Patch.isEmpty()){
                survive(_gameState);
            }
        }
        followPatch();
    }

    private void survive(GameState gameState) {
        Rotation[] rotations = Rotation.values();
        Rotation rotation = rotations[0];
        Direction nextDirection = direction;
        Point nextPosition = new Point(pos).translate(nextDirection.getPoint());
        int i = 2;
        while(0 > gameState.getValue(nextPosition)){
            rotation = rotations[i];
            nextDirection = direction.rotate(rotation);
            nextPosition = new Point(pos).translate(nextDirection.getPoint());
            direction = direction.rotate(Rotation.LEFT);
//            System.out.printf("%d, %d , %d\n",i, direction.getPoint().getX(), direction.getPoint().getY());
            i--;
            if(i<0){
                break;
            }
        }
    }
    
    private boolean patchClear() {
        if(Patch.isEmpty())
            return false;
        for(Point point : Patch){
            if(map[point.getX()][point.getY()] < 0)
                return false;
        }
        return true;
    }

    private boolean targetExist() {
        if(Patch.isEmpty())
            return false;
        return map[target.getX()][target.getY()] > 0;
    }
    
    private Point findTarget() {
        for(int i = 0; i < map.length; i++)
            for(int j = 0; j < map[0].length; j++)
                if(map[i][j] == 1)
                    return new Point(i,j);
        return new Point(0,0);
    }

    private void followPatch() {
        if(!Patch.isEmpty()){
            Point tmp = new Point(Patch.get(1));
            Patch.removeFirst();
//            System.out.printf("%d, %d\n",tmp.getX(), tmp.getY());
            direction = pos.getDirection(tmp);
//            System.out.printf("%d, %d\n",direction.getPoint().getX(), direction.getPoint().getY());

        }
    }
}
//public class AISnake implements Runnable {

//    @Override
//    public void run() {
//        while (true) {
//            move();
//            try {
//                // Czas oczekiwania w milisekundach pomiędzy ruchami węża AI
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
