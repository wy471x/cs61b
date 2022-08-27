import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

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

        OffByOne offByOne = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("racedbq", offByOne));
        assertFalse(palindrome.isPalindrome("", offByOne));
        assertFalse(palindrome.isPalindrome(null, offByOne));
        assertFalse(palindrome.isPalindrome("Ba", offByOne));

        OffByN offByN = new OffByN(5);
        assertTrue(palindrome.isPalindrome("ffaaa", offByN));
        assertTrue(palindrome.isPalindrome("baiedfg", offByN));
        assertFalse(palindrome.isPalindrome("", offByN));
        assertFalse(palindrome.isPalindrome(null, offByN));
        assertFalse(palindrome.isPalindrome("Fa", offByN));

        OffByN offByN2 = new OffByN(7);
        assertTrue(palindrome.isPalindrome("bibi", offByN2));
    }
}
