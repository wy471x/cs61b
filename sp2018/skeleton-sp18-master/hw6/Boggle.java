import java.util.List;

public class Boggle {
    
    // File path of dictionary file
    static String dictPath = "words.txt";

    /**
     * Solves a Boggle puzzle.
     * 
     * @param k The maximum number of words to return.
     * @param boardFilePath The file path to Boggle board file.
     * @return a list of words found in given Boggle board.
     *         The Strings are sorted in descending order of length.
     *         If multiple words have the same length,
     *         have them in ascending alphabetical order.
     */
    public static List<String> solve(int k, String boardFilePath) {
        // YOUR CODE HERE
        In in = new In();
        checkInputNum(k);
        checkDicFile(in);
        String[] strings = in.readAllLines();
        checkRectangular(strings);

        return null;
    }

    public static void checkRectangular(String... strs) {
        int old = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (old != strs[i].length()) {
                throw new IllegalArgumentException("The input board is not rectangular.");
            }
        }
    }

    public static void checkInputNum(int k) {
        if (k <= 0) {
            throw new IllegalArgumentException("k is non-positive.");
        }
    }

    public static void checkDicFile(In in) {
        if (!in.exists()) {
            throw new IllegalArgumentException("The dictionary file does not exist.");
        }
    }
}
