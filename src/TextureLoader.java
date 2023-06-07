public class TextureLoader {
    private static Texture[][] loadedHeadTextures = new Texture[3][3];
    /**
     * Wczytuje tekstury głowy w różnych kierunkach.
     * Tworzy instancje tekstur i zapisuje je w tablicy.
     */
    public static void loadTextures() {
        // Tworzenie instancji tekstur i zapisywanie w tablicy
        loadedHeadTextures[1][0] = new Texture("HeadUp.txt"); //HeadUP
        loadedHeadTextures[2][1] = new Texture("HeadRight.txt"); //HeadRight
        loadedHeadTextures[1][2] = new Texture("HeadDown.txt"); //HeadDown
        loadedHeadTextures[0][1] = new Texture("HeadLeft.txt"); //HeadLeft

        // Możesz dodać więcej tekstur, wczytując dane z plików

        System.out.println("Tekstury zostały wczytane.");
    }
    /**
     * Pobiera teksturę dla określonego kierunku.
     * 
     * @param direction kierunek
     * @return tekstura dla określonego kierunku
     */
    public static Texture getTexture(Direction direction) {
        return loadedHeadTextures[direction.getPoint().getX()+1][direction.getPoint().getY()+1];
    }
}
