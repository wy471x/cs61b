/**
 * @author dunk
 */
public class ArrayDeque<T> implements Deque<T> {

    /**
     * D represent default size of array.
     */
    private final Integer D = 8;
    /**
     * Refactor represent resize factor.
     */
    private final Integer refactor = 2;
    /**
     * elements represent array.
     */
    private T[] elements;
    /**
     * size represent initial size.
     */
    private int size = 0;
    /**
     * R represent usage ratio of array.
     */
    private final double R = 0.25;
    /**
     * first points to first element of deque.
     */
    private int first;
    /**
     * last points to last element of deque.
     */
    private int last;

    /**
     * constructor of ArrayDeque.
     */
    public ArrayDeque() {
        elements = (T[]) new Object[D];
        first = elements.length / 2 - 1;
        last = elements.length / 2;
    }

    /**
     * add element to array.
     */
    /**
     * @param item
     */
    @Override
    public void addFirst(T item) {
        if (size == elements.length) {
            elements = resize(size * refactor, true);
        }
        elements[first] = item;
        first = (first - 1 + elements.length) % elements.length;
        size++;
    }

    /**
     * Resize capacity of array.
     * @param newSize
     * @param flag
     * @return
     */
    private T[] resize(int newSize, boolean flag) {
        if (flag) {
            return resizeUp(newSize);
        }
        return resizeDown(newSize);
    }

    /**
     * Resize up array.
     * @param len
     * @return
     */
    private T[] resizeUp(int len) {
        T[] newElements = (T[]) new Object[len];
        int newFirst = newElements.length / 2 - 1;
        int newLast = newElements.length / 2;
        System.arraycopy(elements, (first + 1) % elements.length,
                newElements, newFirst,
                elements.length - (first + 1) % elements.length);
        System.arraycopy(elements, 0, newElements,
                newFirst + elements.length - (first + 1) % elements.length,
                last);
        first = newFirst - 1;
        last = newElements.length - 1;
        return newElements;
    }

    /**
     * Resize down array.
     * @param len
     * @return
     */
    private T[] resizeDown(int len) {
        T[] newElements = (T[]) new Object[len];
        int newFirst = newElements.length / 2 - 1;
        int newLast = newElements.length / 2;
        System.arraycopy(elements, (first + 1) % elements.length,
                newElements, newFirst,
                elements.length - (first + 1) % elements.length);
        System.arraycopy(elements, 0, newElements,
                newFirst + elements.length - (first + 1) % elements.length,
                last);
        first = newFirst - 1;
        last = newFirst + size;
        return newElements;
    }

    /**
     * Add element to tail of array.
     * @param item
     */
    @Override
    public void addLast(T item) {
        if (size == elements.length) {
            elements = resize(size * refactor, true);
        }
        elements[last] = item;
        last = (last + 1 + elements.length) % elements.length;
        size++;
    }

    /**
     * Remove front element of ArrayDeque.
     * @return
     */
    @Override
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }

        first = (first + 1 + elements.length) % elements.length;
        T result = elements[first];
        size--;

        double ratio = (double) size / elements.length;
        if (ratio < R && elements.length > 16) {
            elements = resize(elements.length / 2, false);
        }
        return result;
    }

    /**
     * Remove tail element of ArrayDeque.
     * @return
     */
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        last = (last - 1 + elements.length) % elements.length;
        T result = elements[last];
        size--;

        double ratio = (double) size / elements.length;
        if (ratio < R && elements.length > 16) {
            elements = resize(elements.length / 2, false);
        }
        return result;
    }

    /**
     * Get element specified position of ArrayDeque.
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        return elements[(first + 1 + index) % elements.length];
    }

    /**
     * Print all elements in ArrayDeque.
     */
    @Override
    public void printDeque() {
        int cur = first + 1;
        while (cur != last - 1) {
            System.out.print(elements[cur] + " ");
            cur = (cur + elements.length + 1) % elements.length;
        }

        if (cur == last - 1) {
            System.out.println(elements[cur]);
        }
    }

    /**
     * Check ArrayDeque whether it is empty.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of ArrayDeque.
     * @return
     */
    @Override
    public int size() {
        return size;
    }




}
