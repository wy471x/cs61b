package synthesizer;

/**
 * @author dunk
 */
public interface BoundedQueue<T> {
    /**
     * Return queue capacity.
     * @return
     */
    int capacity();

    /**
     * Return number of elements in queue.
     * @return
     */
    int fillCount();

    /**
     * Enqueue to queue.
     * @param x
     */
    void enqueue(T x);

    /**
     * Dequeue from queue.
     * @return
     */
    T dequeue();

    /**
     * Get front element of queue.
     * @return
     */
    T peek();

    /**
     * Check queue whether queue is empty.
     * @return
     */
    default boolean isEmpty() {
        return fillCount() == 0;
    }

    /**
     * Check queue whether queue is full.
     * @return
     */
    default boolean isFull() {
        return capacity() == fillCount();
    }
}
