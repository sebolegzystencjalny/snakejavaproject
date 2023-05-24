public class TextureLoader {
    private static Texture[][] loadedHeadTextures = new Texture[3][3];
    
    public static void loadTextures() {
        // Tworzenie instancji tekstur i zapisywanie w tablicy
        loadedHeadTextures[1][0] = new Texture("HeadUp.txt"); //HeadUP
        loadedHeadTextures[2][1] = new Texture("HeadRight.txt"); //HeadRight
        loadedHeadTextures[1][2] = new Texture("HeadDown.txt"); //HeadDown
        loadedHeadTextures[0][1] = new Texture("HeadLeft.txt"); //HeadLeft

        // Możesz dodać więcej tekstur, wczytując dane z plików lub innych źródeł 

        System.out.println("Tekstury zostały wczytane.");
    }

    public static Texture getTexture(Direction direction) {
//        System.out.print((direction.getPoint().getX()+1)+" "+(direction.getPoint().getY()+1) + "\n");
        return loadedHeadTextures[direction.getPoint().getX()+1][direction.getPoint().getY()+1];
    }
}
//
//    UP(new Point(0, -1)),
//    RIGHT(new Point(1, 0)),
//    DOWN(new Point(0, 1)),
//    LEFT(new Point(-1, 0));