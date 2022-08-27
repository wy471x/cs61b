import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offByN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("noon"));
        assertFalse(palindrome.isPalindrome("car"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome(null));
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    @Test
    public void testIsPalindromeByDeque() {
        assertTrue(palindrome.isPalindromeByDeque("noon"));
        assertFalse(palindrome.isPalindromeByDeque("car"));
        assertTrue(palindrome.isPalindromeByDeque("racecar"));
        assertFalse(palindrome.isPalindromeByDeque(""));
        assertFalse(palindrome.isPalindromeByDeque(null));
        assertFalse(palindrome.isPalindromeByDeque("Aa"));
    }

    @Test
    public void testIsPalindromeRecursive() {
        assertTrue(palindrome.isPalindromeRecursive("noon"));
        assertFalse(palindrome.isPalindromeRecursive("car"));
        assertTrue(palindrome.isPalindromeRecursive("racecar"));
        assertFalse(palindrome.isPalindromeRecursive(""));
        assertFalse(palindrome.isPalindromeRecursive(null));
        assertFalse(palindrome.isPalindromeRecursive("Aa"));
    }

    @Test
    public void testIsPalindromeOverload() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("racedbq", offByOne));
        assertFalse(palindrome.isPalindrome("", offByOne));
        assertFalse(palindrome.isPalindrome(null, offByOne));
        assertFalse(palindrome.isPalindrome("Ba", offByOne));
    }

    @Test
    public void testIsPalindromeOffByN() {
        assertTrue(palindrome.isPalindrome("ffaaa", offByN));
        assertTrue(palindrome.isPalindrome("baiedfg", offByN));
        assertFalse(palindrome.isPalindrome("", offByN));
        assertFalse(palindrome.isPalindrome(null, offByN));
        assertFalse(palindrome.isPalindrome("Fa", offByN));
    }
}
