/**
 * @author dunk
 */
public class OffByN implements CharacterComparator {
    /**
     *  Off by N.
     */
    private int n;

    /**
     * Constructor of OffByN.
     * @param num
     */
    public OffByN(int num) {
        this.n = num;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 5;
    }
}
