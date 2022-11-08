package hw4.puzzle;

/**
 * @author wanyong
 * @date 2022/11/3 22:39
 * @desc
 */
public class Board implements WorldState {

    /**
     * Constructs a board from an N-by-N array of tiles where
     * tiles[i][j] = tile at row i, column j
     *
     * @param tiles
     */
    public Board(int[][] tiles) {

    }

    /**
     * Returns value of tile at row i, column j (or 0 if blank)
     *
     * @param i
     * @param j
     * @return
     */
    public int tileAt(int i, int j) {
        return 0;
    }

    /**
     * Returns the board size N
     *
     * @return
     */
    public int size() {
        return 0;
    }

    /**
     * Returns the neighbors of the current board
     *
     * @return
     */
    public Iterable<WorldState> neighbors() {
        return null;
    }

    /**
     * Hamming estimate described below
     *
     * @return
     */
    public int hamming() {
        return 0;
    }

    /**
     * Manhattan estimate described below
     *
     * @return
     */
    public int manhattan() {
        return 0;
    }

    /**
     * Estimated distance to goal. This method should
     * simply return the results of manhattan() when submitted to
     * Gradescope.
     *
     * @return
     */
    public int estimatedDistanceToGoal() {
        return 0;
    }

    /**
     * Returns true if this board's tile values are the same
     * position as y's
     *
     * @param y
     * @return
     */
    @Override
    public boolean equals(Object y) {
        return true;
    }

    /**
     * Returns the string representation of the board.
     * Uncomment this method.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }
}
