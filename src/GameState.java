
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Klasa reprezentująca stan gry.
 */
class GameState {
    ArrayList<Collidable> listOfCollidables = new ArrayList<>();
    ArrayList<Integer> input = new ArrayList<>();
    
    private int[][] map;
    private int x;
    private int y;
    
    /**
     * Konstruktor domyślny klasy GameState.
     */
    GameState(){
        map = new int[1][1];
        x = 1;
        y = 1;
    }   
    /**
     * Konstruktor klasy GameState.
     *
     * @param _x Liczba kolumn mapy.
     * @param _y Liczba wierszy mapy.
     */
    GameState(int _x, int _y, ArrayList<Collidable> _listOfCollidables){
        map = new int[_x][_y];
        x = _x;
        y = _y;
        listOfCollidables = _listOfCollidables;
    }  
    /**
     * Zwraca mapę gry.
     *
     * @return Dwuwymiarowa tablica reprezentująca mapę gry.
     */
    public int[][] getMap(){
        return map;
    }
    /**
     * Zwraca przygotowaną mapę gry uwzględniającą położenie danego obiektu.
     *
     * @param pos Pozycja obiektu.
     * @return Dwuwymiarowa tablica reprezentująca mapę gry uwzględniającą położenie danego obiektu.
     */
    public int[][] getPreparedMap(Point pos){
        int[][] newMap = map;
        if(inRange(pos.getX(),pos.getY()))
            newMap[pos.getX()][pos.getY()] = 0;     
        return newMap;
    }
    /**
     * Zwraca wartość na mapie gry dla danego punktu.
     *
     * @param point Punkt na mapie.
     * @return Wartość na mapie gry dla danego punktu. -100, jeśli punkt jest poza mapą.
     */
    public int getValue(Point point){
        if(!inRange(point.getX(),point.getY()))
            return -100;
        return map[point.getX()][point.getY()];
    }
    /**
     * Zwraca wartość na mapie gry dla danego punktu.
     *
     * @param x Współrzędna X punktu na mapie.
     * @param y Współrzędna Y punktu na mapie.
     * @return Wartość na mapie gry dla danego punktu. -100, jeśli punkt jest poza mapą.
     */ 
    public int getValue(int x, int y){
        if(!inRange(x,y))
            return -100;
        return map[x][y];
    }
    /**
     * Ustala wartość na mapie gry dla listy punktów.
     *
     * @param pos   Lista punktów.
     * @param value Wartość do ustalenia na mapie gry.
     */
    public void locateEntities(ArrayList<Point> pos, int value){
        for (Point point : pos) {
            if(inRange(point.getX(),point.getY()))
                map[point.getX()][point.getY()] = value;
        }
    }
    /**
     * Czyści mapę gry.
     */
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
    /**
     * Zwraca losową wolną przestrzeń na mapie.
     *
     * @return Punkt reprezentujący losową wolną przestrzeń na mapie.
     */
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
    /**
     * Zwraca listę wciśniętych klawiszy.
     *
     * @return Lista wciśniętych klawiszy.
     */
    public ArrayList getInputed(){
        return input;
    }
    
    public void observe() {
        ereaseMap();
        for (Collidable collidable : listOfCollidables) {
            locateEntities(collidable.locate(),((Entity)collidable).getValue());
        }
    }
    
    /**
     * Dodaje wciśnięty klawisz do listy.
     *
     * @param key Kod wciśniętego klawisza.
     */
    public void addInput(int key){
        input.add(key);
    }
    
    /**
     * Czyści listę wciśniętych klawiszy.
     */
    void clearInput() {
        input.clear();
    }
}