
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

class GameState {
    ArrayList<Integer> input = new ArrayList<>();
    private int[][] map;
    private int x;
    private int y;
    
    GameState(){
        map = new int[1][1];
        x = 1;
        y = 1;
    }   
    
    GameState(int _x, int _y){
        map = new int[_x][_y];
        x = _x;
        y = _y;
    }  
    
    public int[][] getMap(){
        return map;
    }
    
    public int[][] getPreparedMap(Point pos){
        int[][] newMap = map;
        if(inRange(pos.getX(),pos.getY()))
            newMap[pos.getX()][pos.getY()] = 0;     
        return newMap;
    }
    
    public int getValue(Point point){
        if(!inRange(point.getX(),point.getY()))
            return -100;
        return map[point.getX()][point.getY()];
    }
        
    public int getValue(int x, int y){
        if(!inRange(x,y))
            return -100;
        return map[x][y];
    }
    
    public void locateEntities(ArrayList<Point> pos, int value){
        for (Point point : pos) {
            if(inRange(point.getX(),point.getY()))
                map[point.getX()][point.getY()] = value;
        }
    }
    
    public void ereaseMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 0;
            }
        }
    }

    private boolean inRange(int _x, int _y) {
        return (_x > -1 && _y > -1 && _x < x && _y < y);
    }
    
    public Point randomFreeSpace(){
        LinkedList <Point> freeSpace = new LinkedList<>();
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (map[i][j] == 0){
                    freeSpace.add(new Point(i,j));
                }
            }
        }
        Random random = new Random();
        int randomIndex = random.nextInt(freeSpace.size());
        return freeSpace.get(randomIndex);
    }

    public ArrayList getInputed(){
        return input;
    }
    
    public void addInput(int key){
        input.add(key);
    }
    
    void clearInput() {
        input.clear();
    }
}