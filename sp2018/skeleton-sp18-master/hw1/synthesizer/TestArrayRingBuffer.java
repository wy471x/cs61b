package synthesizer;
import org.junit.Test;

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
        assertEquals(10, arb.fillCount());
    }

    @Test
    public void testUnderflow() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(10);
        assertEquals(10, arb.capacity());

        for (int i = 0; i < 10; i++) {
            Integer dequeue = arb.dequeue();
            assertEquals("expected:" + i + " actual:" + dequeue, String.valueOf(i), String.valueOf(dequeue));
        }
        assertEquals(0, arb.fillCount());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
