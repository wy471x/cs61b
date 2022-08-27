import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author dunk
 */
public class TestArrayDequeGold {
    /**
     * @source StudentArrayDequeLauncher
     */
    @Test
    public void test() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();

        for (int i = 0; i < 24; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                sad1.addLast(i);
                ads1.addLast(i);
            } else {
                sad1.addFirst(i);
                ads1.addFirst(i);
            }

            if (ads1.get(i) != sad1.get(i)) {
                System.out.println("output is disagree.");
                break;
            }
        }
        sad1.printDeque();
    }
}
