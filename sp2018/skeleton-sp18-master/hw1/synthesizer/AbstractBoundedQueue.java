package synthesizer;

/**
 * @author dunk
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    /**
     * Count filled in queue.
     */
    protected int fillCount;

    /**
     * Capacity of queue.
     */
    protected int capacity;
}
