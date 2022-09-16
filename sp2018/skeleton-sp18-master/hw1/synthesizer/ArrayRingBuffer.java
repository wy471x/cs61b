package synthesizer;

import java.util.Iterator;

/**
 * @author dunk
 */
public class ArrayRingBuffer<T> extends AbstractBoundedQueue {
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
    public void enqueue(Object x) {
        if (isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        rb[last] = (T) x;
        last = (last + 1) % capacity;
        fillCount  += 1;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     *
     * @return
     */
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
        return rb[first];
    }

    @Override
    public Iterator iterator() {
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

        /**
         * Constructor.
         */
        ArrayRingBufferIterator() {
            ptr = first;
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            T result = rb[ptr];
            ptr = (ptr + 1) % capacity;
            return result;
        }
    }
}
