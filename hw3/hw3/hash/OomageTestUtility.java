package hw3.hash;

import java.util.List;

public class OomageTestUtility {

    public static final int MAGIC = 0x7FFFFFFF;

    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int N = oomages.size();
        double low = (double) N / 50, hight = N / 2.5;
        int[] oomageArray = new int[M];
        for (Oomage oomage : oomages) {
            oomageArray[(oomage.hashCode() & MAGIC) % M]++;
        }

        for (int i = 0; i < M; i++) {
            if (oomageArray[i] <= low || oomageArray[i] >= hight) {
                return false;
            }
        }
        return true;
    }
}
