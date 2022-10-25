/**
 * Class with 2 ways of doing Counting sort, one naive way and one "better" way
 *
 * @author Akhil Batra, Alexander Hwang
 *
 **/
public class CountingSort {
    /**
     * Counting sort on the given int array. Returns a sorted version of the array.
     * Does not touch original array (non-destructive method).
     * DISCLAIMER: this method does not always work, find a case where it fails
     *
     * @param arr int array that will be sorted
     * @return the sorted array
     */
    public static int[] naiveCountingSort(int[] arr) {
        // find max
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = max > i ? max : i;
        }

        // gather all the counts for each value
        int[] counts = new int[max + 1];
        for (int i : arr) {
            counts[i]++;
        }

        // when we're dealing with ints, we can just put each value
        // count number of times into the new array
        int[] sorted = new int[arr.length];
        int k = 0;
        for (int i = 0; i < counts.length; i += 1) {
            for (int j = 0; j < counts[i]; j += 1, k += 1) {
                sorted[k] = i;
            }
        }

        // however, below is a more proper, generalized implementation of
        // counting sort that uses start position calculation
        int[] starts = new int[max + 1];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += counts[i];
        }

        int[] sorted2 = new int[arr.length];
        for (int i = 0; i < arr.length; i += 1) {
            int item = arr[i];
            int place = starts[item];
            sorted2[place] = item;
            starts[item] += 1;
        }

        // return the sorted array
        return sorted2;
    }

    /**
     * Counting sort on the given int array, must work even with negative numbers.
     * Note, this code does not need to work for ranges of numbers greater
     * than 2 billion.
     * Does not touch original array (non-destructive method).
     *
     * @param arr int array that will be sorted
     */
    public static int[] betterCountingSort(int[] arr) {
        // TODO make counting sort work with arrays containing negative numbers.
        int[] negative = generateNegative(arr);
        int[] positive = generatePositive(arr);
        int[] result;
        int j = 0;
        if (negative != null) {
            result = new int[negative.length + positive.length];
            for (int i = negative.length - 1; i >= 0; i--, j++) {
                result[j] = -negative[i];
            }
        } else {
            result = new int[positive.length];
        }

        for (int i = 0; i < positive.length; i++, j++) {
            result[j] = positive[i];
        }
        return result;
    }

    private static int[] generateNegative(int[] arr) {
        // find max
        int max = 0, size = 0;
        for (int i : arr) {
            if (i < 0) {
                size++;
                max = max > -i ? max : -i;
            }
        }

        if (max == 0) {
            return null;
        }

        // gather all the counts for each value
        int[] counts = new int[max + 1];
        for (int i : arr) {
            if (i < 0) {
                counts[-i]++;
            }
        }

        // when we're dealing with ints, we can just put each value
        // count number of times into the new array
        int[] sorted = new int[size];
        int k = 0;
        for (int i = 0; i < counts.length; i += 1) {
            for (int j = 0; j < counts[i]; j += 1, k += 1) {
                sorted[k] = i;
            }
        }
        return sorted;
    }

    private static int[] generatePositive(int[] arr) {
        // find max
        int max = Integer.MIN_VALUE, size = 0;
        for (int i : arr) {
            if (i >= 0) {
                size++;
                max = max > i ? max : i;
            }
        }

        // gather all the counts for each value
        int[] counts = new int[max + 1];
        for (int i : arr) {
            if (i >= 0) {
                counts[i]++;
            }
        }

        // when we're dealing with ints, we can just put each value
        // count number of times into the new array
        int[] sorted = new int[size];
        int k = 0;
        for (int i = 0; i < counts.length; i += 1) {
            for (int j = 0; j < counts[i]; j += 1, k += 1) {
                sorted[k] = i;
            }
        }
        return sorted;
    }
}
