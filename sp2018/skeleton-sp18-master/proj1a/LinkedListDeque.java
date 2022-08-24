public class LinkedListDeque<T> {
    private LinkedList list;

    public LinkedListDeque() {
        list = new LinkedList();
    }

    public void addFirst(T item) {
        list.addFirst(item);
    }

    public void addLast(T item) {
        list.addLast(item);
    }

    public T removeFirst() {
        return (T)list.removeFirst();
    }

    public T removeLast() {
        return (T)list.removeLast();
    }

    public T get(int index) {
        return (T)list.get(index);
    }

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

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }


    private class LinkedList<T> {
        private class Node<T> {
            public T item;
            public Node prev;
            public Node next;

            public Node(T i) {
                item = i;
                next = null;
                prev = null;
            }

            public Node() {
            }
        }

        private Node sentinel;
        private Node first;
        private Node last;
        private int size;

        public Node getFirst() {
            return first;
        }

        public Node getLast() {
            return last;
        }

        public Node getSentinel() {
            return sentinel;
        }

        public LinkedList() {
            sentinel = new Node();
            first = sentinel;
            last = sentinel;
            sentinel.next = first;
            sentinel.prev = last;
            size = 0;
        }

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

        public void addLast(T item) {
            Node node = new Node(item);
            node.next = last.next;
            node.prev = last;
            last.next = node;
            last = node;
            sentinel.prev = last;
            size += 1;
        }


        public T removeFirst() {
            T result = (T)first.item;
            first = first.next;
            sentinel.next = first;
            first.prev = sentinel;
            size -= 1;
            return result;
        }

        public T removeLast() {
            T result = (T)last.item;
            last = last.prev;
            last.next = sentinel;
            sentinel.prev = last;
            size -= 1;
            return result;
        }

        public T get(int index) {
            if (index >= size || index < 0) {
                return null;
            }

            Node p = sentinel;
            int i = 0;
            while (i <= index) {
                p = p.next;
            }
            return (T)p.item;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int size() {
            return size;
        }

    }
}
