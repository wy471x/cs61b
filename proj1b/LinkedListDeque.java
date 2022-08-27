/**
 * @author dunk
 */
public class LinkedListDeque<T> implements Deque<T> {
    /**
     * List contained all elements.
     */
    private LinkedList list;

    /**
     * Constructor of LinkedListDeque.
     */
    public LinkedListDeque() {
        list = new LinkedList();
    }

    /**
     * Add element to front of LinkedListDeque.
     * @param item
     */
    @Override
    public void addFirst(T item) {
        list.addFirst(item);
    }

    /**
     * Add element to tail of LinkedListDeque.
     * @param item
     */
    @Override
    public void addLast(T item) {
        list.addLast(item);
    }

    /**
     * Remove front element of LinkedListDeque.
     * @return
     */
    @Override
    public T removeFirst() {
        return (T) list.removeFirst();
    }

    /**
     * Remove tail element of LinkedListDeque.
     * @return
     */
    @Override
    public T removeLast() {
        return (T) list.removeLast();
    }

    /**
     * Get element specified position in LinkedListDeque by iterative way.
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        return (T) list.get(index);
    }

    /**
     * Get element specified position in LinkedListDeque by recursive way.
     * @param index
     * @return
     */
    public T getRecursive(int index) {
        return (T) list.getRecursive(index);
    }

    /**
     * Print all element of deque.
     */
    @Override
    public void printDeque() {
        LinkedList.Node sentinel = list.getSentinel(), cur = sentinel.next;
        while (cur.next != sentinel) {
            System.out.print(cur.item + " ");
            cur = cur.next;
        }

        if (cur == sentinel) {
            System.out.println("");
        }
        System.out.println(cur.item);
    }

    /**
     * Check deque whether it is empty.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Return size of deque.
     * @return
     */
    @Override
    public int size() {
        return list.size();
    }


    /**
     * Define private class of deque based linked list.
     */
    private class LinkedList<T> {

        /**
         * Define private class of linked list.
         */
        private class Node<T> {
            /**
             * Element in linked list.
             */
            private T item;

            /**
             * Previous pointer to current node.
             */
            private Node prev;

            /**
             * Next pointers to current node.
             */
            private Node next;

            /**
             * Constructor of Node.
             * @param i
             */
            Node(T i) {
                item = i;
                next = null;
                prev = null;
            }

            /**
             * Default constructor.
             */
            Node() {
            }
        }

        /**
         * Sentinel node.
         */
        private Node sentinel;

        /**
         * First node.
         */
        private Node first;

        /**
         * Last node.
         */
        private Node last;

        /**
         * Size of linked list.
         */
        private int size;

        /**
         * Get first element in linked list.
         * @return
         */
        public Node getFirst() {
            return first;
        }

        /**
         * Get last element in linked list.
         * @return
         */
        public Node getLast() {
            return last;
        }

        /**
         * Get sentinel pointer of linked list.
         * @return
         */
        public Node getSentinel() {
            return sentinel;
        }

        /**
         * Constructor of linked list.
         */
        LinkedList() {
            sentinel = new Node();
            first = sentinel;
            last = sentinel;
            sentinel.next = first;
            sentinel.prev = last;
            size = 0;
        }

        /**
         * Add element to front of linked list.
         * @param item
         */
        public void addFirst(T item) {
            Node node = new Node(item);
            node.next = sentinel.next;
            node.prev = sentinel;
            first.prev = node;
            first = node;
            sentinel.next = first;
            last = sentinel.prev;
            size += 1;
        }

        /**
         * Add element to tail of linked list.
         * @param item
         */
        public void addLast(T item) {
            Node node = new Node(item);
            node.next = last.next;
            node.prev = last;
            last.next = node;
            last = node;
            sentinel.prev = last;
            if (0 == size) {
                first = node;
            }
            size += 1;
        }

        /**
         * Remove front element in linked list.
         * @return
         */
        public T removeFirst() {
            if (size <= 0) {
                return null;
            }

            T result = (T) first.item;
            first = first.next;
            sentinel.next = first;
            first.prev = sentinel;
            if (first == sentinel) {
                last = sentinel;
            }
            size -= 1;
            return result;
        }

        /**
         * Remove tail element in linked list.
         * @return
         */
        public T removeLast() {
            if (size <= 0) {
                return null;
            }

            T result = (T) last.item;
            if (first == last) {
                first = sentinel;
            }
            last = last.prev;
            last.next = sentinel;
            sentinel.prev = last;
            size -= 1;
            return result;
        }

        /**
         * Get element specified position in linked list by iterative way.
         * @param index
         * @return
         */
        public T get(int index) {
            if (index >= size || index < 0) {
                return null;
            }

            Node p = sentinel;
            int i = 0;
            while (i <= index) {
                p = p.next;
                i++;
            }
            return (T) p.item;
        }

        /**
         * Get element specified position in linked list by recursive way.
         * @param index
         * @return
         */
        public T getRecursive(int index) {
            if (index >= size || index < 0) {
                return null;
            }

            Node n = sentinel.next;
            int i = 0;
            return helper(i, index, n);
        }

        /**
         * This is helper function for "getRecursive".
         * @param cur
         * @param index
         * @param n
         * @return
         */
        private T helper(int cur, int index, Node n) {
            if (cur == index) {
                return (T) n.item;
            }
            return (T) helper(cur + 1, index, n.next);
        }

        /**
         * Check linked list whether it is empty.
         * @return
         */
        public boolean isEmpty() {
            return size == 0;
        }

        /**
         * Return size of linked list.
         * @return
         */
        public int size() {
            return size;
        }

    }
}
