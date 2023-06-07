/**
 * Enumeracja Rotation reprezentuje obrót, który może być prawo-, lewo- lub brak obrotu.
 */
public enum Rotation {
    RIGHT(1),
    LEFT(-1),
    FORWARD(0);

    private final int value;
    /**
     * Konstruktor enumeracji Rotation.
     * @param value wartość reprezentująca obrót
     */
    Rotation(int value) {
        this.value = value;
    }
    /**
     * Metoda getValue zwraca wartość reprezentującą obrót.
     * @return wartość reprezentująca obrót
     */
    public int getValue() {
        return value;
    }
}