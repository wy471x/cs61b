package hw4.puzzle;

/**
 * @author wanyong
 * @date 2022/11/3 22:39
 * @desc
 */
public class Board {

    public Board(int[][] tiles) {

    }

    public int tileAt(int i, int j) {
        return 0;
    }

    public int size() {
        return 0;
    }

    public Iterable<WorldState>  neighbors() {
        return null;
    }

    public int hamming() {
        return 0;
    }

    public int manhattan() {
        return 0;
    }

    public int estimatedDistanceToGoal() {
        return 0;
    }

    @Override
    public boolean equals(Object y) {
        return true;
    }

    /** Returns the string representation of the board. 
      * Uncomment this method. */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i,j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }
}
