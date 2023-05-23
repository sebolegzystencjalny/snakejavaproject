import java.util.*;

public class BFSAlgorithm {
    public static LinkedList<Point> findPath(int[][] map, Point start, Point end) {
        int rows = map.length;
        int cols = map[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Point[][] parent = new Point[rows][cols];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.equals(end)) {
                return constructPath(parent, start, end);
            }

            for (Direction move : Direction.values()) {
                int newRow = current.getX() + move.getPoint().getX();
                int newCol = current.getY() + move.getPoint().getY();
                if (isValidMove(map, visited, newRow, newCol)) {
                    Point neighbor = new Point(newRow, newCol);
                    queue.add(neighbor);
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                }
            }
        }

        return new LinkedList<>(); // No path found
    }
    
    public static LinkedList<Point> findPath(int[][] map, Point start) {
        int rows = map.length;
        int cols = map[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Point[][] parent = new Point[rows][cols];

        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getX()][start.getY()] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (map[current.getX()][current.getY()]>0) {
                Point end = new Point(current);
                return constructPath(parent, start, end);
            }

            for (Direction move : Direction.values()) {
                int newRow = current.getX() + move.getPoint().getX();
                int newCol = current.getY() + move.getPoint().getY();
                if (isValidMove(map, visited, newRow, newCol)) {
                    Point neighbor = new Point(newRow, newCol);
                    queue.add(neighbor);
                    visited[newRow][newCol] = true;
                    parent[newRow][newCol] = current;
                }
            }
        }

        return new LinkedList<>(); // No path found
    }

     private static boolean isValidMove(int[][] map, boolean[][] visited, int row, int col) {
        return (!visited[row][col] && map[row][col] > -1);
    }

    private static LinkedList<Point> constructPath(Point[][] parent, Point start, Point end) {
        LinkedList<Point> path = new LinkedList<>();
        Point current = end;

        while (!current.equals(start)) {
            path.add(current);
            current = parent[current.getX()][current.getY()];
        }

        path.add(start);
        Collections.reverse(path);
        return path;
    }
}
