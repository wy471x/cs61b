/**
 * @author dunk
 *
 * Definition of deque.
 */
public interface Deque<T> {
    /**
     * Add an element front of deque.
     * @param item
     */
    void addFirst(T item);

    /**
     * Add an element tail of deque.
     * @param item
     */
    void addLast(T item);

    /**
     * Check deque whether it is empty.
     * @return
     */
    boolean isEmpty();

    /**
     * Return number of total elements in deque.
     * @return
     */
    int size();

    /**
     * Print all elements in deque.
     */
    void printDeque();

    /**
     * Remove front element of deque.
     * @return
     */
    T removeFirst();

    /**
     * Remove tail element of deque.
     * @return
     */
    T removeLast();

    /**
     * Return element specified position in deque.
     * @param index
     * @return
     */
    T get(int index);
}
