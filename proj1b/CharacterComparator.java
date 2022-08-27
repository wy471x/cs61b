/**
 * This interface defines a method
 * for determining equality of characters.
 * @author dunk
 * */
public interface CharacterComparator {
    /**
     * Returns true if characters are equal by the rules of
     * the implementing class.
     * @param x
     * @param y
     * */
    boolean equalChars(char x, char y);
}
