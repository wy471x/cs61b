public class ArrayDeque<T> {
    private final Integer DEFAULT = 16;
    private final Double REFACTOR = 1.75;
    private T[] elements;
    private int size = 0;
    private int R = 0;
    private int first;
    private int last;

    public ArrayDeque() {
        elements = (T[])new Object[DEFAULT];
        first = elements.length / 2 - 1;
        last = elements.length / 2;
    }

    public void addFirst(T item) {
        if (size == elements.length) {
            elements = resize((int) (size * REFACTOR));
        }
        elements[first] = item;
        if (first <= 0) {
            first = elements.length - 1;
        } else {
            first--;
        }
        size++;
    }

    private T[] resize(int newSize) {
        T[] newElements = (T[])new Object[newSize];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        return newElements;
    }

    public void addLast(T item) {
        if (size == elements.length) {
            elements = resize((int) (size * REFACTOR));
        }
        elements[last] = item;
        if (last >= elements.length) {
            last = 0;
        } else {
            last++;
        }
        size++;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T result;
        if (first == elements.length - 1) {
            result = elements[0];
        } else {
            result = elements[++first];
        }
        size--;
        return result;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T result;
        if (last == 0) {
            result = elements[elements.length - 1];
        } else {
            result = elements[--last];
        }
        size--;
        return result;
    }

    public void printDeque() {
        int cur = first + 1;
        while (cur != last) {
            System.out.print(elements[cur] + " ");
            cur = (cur + elements.length) % elements.length;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }




}
