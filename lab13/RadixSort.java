/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {

    private static int maxLen = 0;
    private static String[] newAsciis;

    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        newAsciis = new String[asciis.length];
        for (String str : asciis) {
            maxLen = maxLen > str.length() ? maxLen : str.length();
        }

        for (int i = 0; i < maxLen; i++) {
            sortHelperLSD(asciis, i);
        }
        return newAsciis;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] radix = new int[256];
        for (int i = 0; i < asciis.length; i++) {
            if (maxLen - asciis[i].length() > index) {
                radix[0]++;
            } else {
                radix[asciis[i].charAt(index)]++;
            }
        }

        int added = 0;
        for (int i = 0; i < radix.length; i++) {
            radix[i] += added;
            added = radix[i];
        }

        for (int i = asciis.length - 1; i >= 0; i--) {
            if (maxLen - asciis[i].length() > index) {
                radix[0]--;
                newAsciis[radix[0]] = asciis[i];
            } else {
                radix[asciis[i].charAt(index)]--;
                newAsciis[radix[asciis[i].charAt(index)]] = asciis[i];
            }
        }
        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
