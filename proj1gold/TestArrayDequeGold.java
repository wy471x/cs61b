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
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i += 1) {
            if (ads.size() == 0) {
                int addNumber = StdRandom.uniform(1000);
                int headOrBack = StdRandom.uniform(2);
                if (headOrBack == 0) {
                    log = log + "addFirst(" + addNumber + ")\n";
                    sad.addFirst(addNumber);
                    ads.addFirst(addNumber);
                } else {
                    log = log + "addLast(" + addNumber + ")\n";
                    sad.addLast(addNumber);
                    ads.addLast(addNumber);
                }
            } else {
                int x = StdRandom.uniform(4);
                int addNumber = StdRandom.uniform(1000);
                Integer testRemoveNumber = 1;
                Integer stdRemoveNumber = 1;
                switch (x) {
                    case 0:
                        log = log + "addFirst(" + addNumber + ")\n";
                        sad.addFirst(addNumber);
                        ads.addFirst(addNumber);
                        break;
                    case 1:
                        log = log + "addLast(" + addNumber + ")\n";
                        sad.addLast(addNumber);
                        ads.addLast(addNumber);
                        break;
                    case 2:
                        log = log + "removeFirst()\n";
                        testRemoveNumber = sad.removeFirst();
                        stdRemoveNumber = ads.removeFirst();
                        break;
                    case 3:
                        log = log + "removeLast()\n";
                        testRemoveNumber = sad.removeLast();
                        stdRemoveNumber = ads.removeLast();
                        break;
                    default:
                }
                assertEquals(log, stdRemoveNumber, testRemoveNumber);
            }
        }
    }
}
