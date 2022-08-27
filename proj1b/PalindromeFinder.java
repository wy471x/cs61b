/**
 * This class outputs all palindromes
 * in the words file in the current directory.
 * @author dunk
 * */
public class PalindromeFinder {
    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();

        printPalindrome(palindrome, in, minLength);
        printPalindromeOffByOne(palindrome, in, minLength);
        printPalindromeOffByN(palindrome, in, minLength, 5);
    }

    /**
     * Print all palindrome words.
     * @param palindrome
     * @param in
     * @param minLength
     */
    public static void printPalindrome(Palindrome palindrome,
                                       In in, int minLength) {
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
    }

    /**
     * Print all palindrome words.
     * @param palindrome
     * @param in
     * @param minLength
     */
    public static void printPalindromeOffByOne(Palindrome palindrome,
                                               In in, int minLength) {
        OffByOne offByOne = new OffByOne();
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength
                    && palindrome.isPalindrome(word, offByOne)) {
                System.out.println(word);
            }
        }
    }

    /**
     * Print all palindrome words for which each characters off by N.
     * @param palindrome
     * @param in
     * @param minLength
     * @param n
     */
    public static void printPalindromeOffByN(Palindrome palindrome,
                                             In in, int minLength, int n) {
        OffByN offByN = new OffByN(n);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength
                    && palindrome.isPalindrome(word, offByN)) {
                System.out.println(word);
            }
        }
    }
}
