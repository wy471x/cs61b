/**
 * @author dunk
 */
public class Palindrome {
    /**
     * Revert each character in word to deque.
     * @param word
     * @return
     */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /**
     * Check word if it is palindrome.
     * For example "racecar" and "noon".
     * @param word
     * @return
     */
    public boolean isPalindrome(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check word if it is palindrome.
     * For example "racecar" and "noon".
     * @param word
     * @return
     */
    private boolean isPalindromeByDeque(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        while (!wordDeque.isEmpty()) {
            Character front = wordDeque.removeFirst();
            Character tail = wordDeque.removeLast();
            if (tail == null) {
                break;
            }
            if (!front.equals(tail)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check word if it is palindrome.
     * For example "racecar" and "noon".
     * @param word
     * @return
     */
    private boolean isPalindromeRecursive(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Deque<Character> wordDeque = wordToDeque(word);
        return helper(wordDeque);
    }

    /**
     * Helper function of checking whether word is palindrome.
     * @param deque
     * @return
     */
    private boolean helper(Deque<Character> deque) {
        if (deque.isEmpty()) {
            return true;
        }

        Character front = deque.removeFirst(), tail = deque.removeLast();
        if (tail == null) {
            return true;
        }
        return front == tail && helper(deque);
    }

    /**
     * Check word if it is palindrome.
     * For example "racecar" and "noon".
     * @param word
     * @param offByOne
     * @return
     */
    public boolean isPalindrome(String word, OffByOne offByOne) {
        if (word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (!offByOne.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check word if it is palindrome.
     * For example "racecar" and "noon".
     * @param word
     * @param offByN
     * @return
     */
    public boolean isPalindrome(String word, OffByN offByN) {
        if (word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0, j = word.length() - 1; i < j; i++, j--) {
            if (!offByN.equalChars(word.charAt(i), word.charAt(j))) {
                return false;
            }
        }
        return true;
    }
}
