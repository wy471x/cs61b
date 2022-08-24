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
}
