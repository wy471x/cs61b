package synthesizer;
import org.junit.Test;

import java.util.Iterator;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    private static final int CAPACITY = 10;
    private static final int MAX = 10;

    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(CAPACITY);
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arrayRingBuffer = new ArrayRingBuffer<>(CAPACITY);
        for (int i = 0; i < MAX; i++) {
            arrayRingBuffer.enqueue(i);
        }
        Iterator<Integer> iterator = arrayRingBuffer.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int n = iterator.next();
            assertEquals("expected:" + i + " actual:" + n, String.valueOf(i), String.valueOf(n));
            i++;
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
