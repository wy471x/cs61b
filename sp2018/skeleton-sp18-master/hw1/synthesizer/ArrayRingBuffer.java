package synthesizer;

import java.util.Iterator;

/**
 * @author dunk
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /**
     * Index for the next dequeue or peek.
     */
    private int first;

    /**
     * Index for the next enqueue.
     */
    private int last;

    /**
     * Array for storing the buffer data.
     */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     * @param capacity
     */
    public ArrayRingBuffer(int capacity) {
        this.capacity = capacity;
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     * @param x
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        rb[last] = x;
        last = (last + 1) % capacity;
        fillCount  += 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     *
     * @return
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        T result = rb[this.first];
        rb[first] = null;
        first = (first + 1) % capacity;
        fillCount -= 1;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    /**
     * Implement iterator.
     */
    private class ArrayRingBufferIterator implements Iterator<T> {
        /**
         * Pointer.
         */
        private int ptr;
        private int cnt;

        /**
         * Constructor.
         */
        ArrayRingBufferIterator() {
            ptr = first;
            cnt = 0;
        }

        @Override
        public boolean hasNext() {
            return ptr != last || cnt != fillCount();
        }

        @Override
        public T next() {
            T result = rb[ptr];
            ptr = (ptr + 1) % capacity;
            cnt++;
            return result;
        }
    }
}
