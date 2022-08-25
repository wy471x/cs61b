/**
 * @author dunk
 */
public class ArrayDeque<T> {

    /**
     * D represent default size of array.
     */
    private final Integer D = 8;
    /**
     * _refactor represent resize factor.
     */
    private final Double _refactor = 1.75;
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
    private final int R = 0;
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
    public void addFirst(T item) {
        if (size == elements.length) {
            elements = resize((int) (size * _refactor));
        }
        elements[first] = item;
        first = (first - 1 + elements.length) % elements.length;
        size++;
    }

    /**
     * Resize capacity of array.
     * @param newSize
     * @return
     */
    private T[] resize(int newSize) {
        T[] newElements = (T[]) new Object[newSize];
        int newFirst = newElements.length / 2 - 1, newLast = newElements.length / 2;
        System.arraycopy(elements, first + 1, newElements, newFirst, elements.length - first - 1);
        System.arraycopy(elements, 0, newElements, elements.length - 1, last);
        first = newFirst - 1;
        last = (newLast + last) % newElements.length;
        return newElements;
    }

    /**
     * Add element to tail of array.
     * @param item
     */
    public void addLast(T item) {
        if (size == elements.length) {
            elements = resize((int) (size * _refactor));
        }
        elements[last] = item;
        last = (last + 1 + elements.length) % elements.length;
        size++;
    }

    /**
     * Remove front element of ArrayDeque.
     * @return
     */
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }

        T result = elements[first = (first + 1 + elements.length) % elements.length];
        size--;
        return result;
    }

    /**
     * Remove tail element of ArrayDeque.
     * @return
     */
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T result = elements[last = (last - 1 + elements.length) % elements.length];
        size--;
        return result;
    }

    /**
     * Get element specified position of ArrayDeque.
     * @param index
     * @return
     */
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        return elements[(first + 1 + index) % elements.length];
    }

    /**
     * Print all elements in ArrayDeque.
     */
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
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of ArrayDeque.
     * @return
     */
    public int size() {
        return size;
    }




}
