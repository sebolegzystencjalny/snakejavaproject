
import java.util.ArrayList;

class GameState {
    private Rotation playerRotation;
    private int[][] map;
    private int x;
    private int y;
    
    GameState(){
        playerRotation = Rotation.FORWARD;
        map = new int[1][1];
        x = 1;
        y = 1;
    }   
    
    GameState(int _x, int _y){
        playerRotation = Rotation.FORWARD;
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
    
    public Rotation getRotation(){
        Rotation rotation = playerRotation;
        playerRotation = Rotation.FORWARD;
        return rotation;
    }
    
    public void setRotation(Rotation rotation){
        playerRotation = rotation;
    }

    private boolean inRange(int _x, int _y) {
        return (_x > -1 && _y > -1 && _x < x && _y < y);
    }
}