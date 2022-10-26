import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * @author dunk
 * @date 2022/10/25 20:49
 */
public class RxdixSortTester {


    private static String[] strings = {"aaa", "bacf", "c", "eb", "dd", "zw"};

    public static void assertIsSorted(String[] strs) {
        String previous = String.valueOf((char)0);
        for (String str : strs) {
            assertTrue(str.compareTo(previous) > 0);
            previous = str;
        }
    }

    @Test
    public void testRadixSortLSD() {
        String[] sort = RadixSort.sort(strings);
        assertIsSorted(sort);
    }

    @Test
    public void testArraySort() {
        String[] strs = {"aa", "ba", "ce", "eb", "dd", "zw"};
        Arrays.sort(strs);
        assertIsSorted(strs);
    }


    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(CountingSortTester.class);
    }
}
