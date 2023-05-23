import java.util.ArrayList;

public class EntityManager {
    private ArrayList<Movable> listOfMovables = new ArrayList<>();
    private ArrayList<Renderable> listOfRenderables = new ArrayList<>();
    private ArrayList<Collidable> listOfCollidables = new ArrayList<>();
    
    private ArrayList<Obstacle> listOfObstacles = new ArrayList<>();
    private ArrayList<Playable> listOfPlayables = new ArrayList<>();
    private ArrayList<Edible> listOfEdibles = new ArrayList<>();
}
