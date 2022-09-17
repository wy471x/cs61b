package synthesizer;
import org.junit.Test;

import java.util.Iterator;
import java.util.Optional;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void testOverflow() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
    }

    @Test
    public void testUnderflow() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());
    }

    @Test
    public void testIterator() {
        ArrayRingBuffer<Integer> arrayRingBuffer = new ArrayRingBuffer<>(10);
        for (int i = 0; i < 10; i++) {
            arrayRingBuffer.enqueue(i);
        }
        Iterator<Integer> iterator = arrayRingBuffer.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            int n = iterator.next();
            System.out.println(n);
            assertEquals("expected:" + i + " actual:" + n, String.valueOf(i), String.valueOf(n));
            i++;
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
