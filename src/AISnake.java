import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class AISnake extends Snake implements Movable {
    public static List<Point> Patch;
    
     public AISnake(int x, int y, int _ID) {
        super(x, y, _ID);
    }
    
    public AISnake(int x, int y, int _ID, Direction _direction, int _size) {
        super(x, y, _ID, _direction, _size);
    }
    
    @Override
    public void think(GameState gameState){
        if(!patchClear() || !targetExist() || Patch.isEmpty()){
            Patch = BFSAlgorithm.findPath(gameState.getPreparedMap(pos), pos, new Point(20,30));
            if(Patch.isEmpty()){
                //jeżeli nie znajdzie ścieżki to błądzenie losowe tak aby sie nie zabić
            }
        }
    }

    private boolean patchClear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private boolean targetExist() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
