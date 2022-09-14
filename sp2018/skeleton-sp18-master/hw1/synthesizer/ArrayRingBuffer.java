package synthesizer;

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
        this.first = 0;
        this.last = 0;
        this.rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     * @param x
     */
    @Override
    public void enqueue(Object x) {
        if (this.capacity == this.fillCount) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        if (this.fillCount == 0) {
            this.rb[this.last] = (T) x;
        } else {
            this.last = (++this.last) % this.capacity;
            this.rb[this.last] = (T) x;
        }
        this.fillCount  += 1;
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.fillCount;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     *
     * @return
     */
    public T dequeue() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        T result = this.rb[this.first];
        this.rb[this.first] = null;
        this.first = (this.first + 1) % this.capacity;
        this.fillCount -= 1;
        return result;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (this.fillCount == 0) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        return this.rb[this.first];
    }
}
