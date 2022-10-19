import edu.princeton.cs.algs4.Queue;
import org.junit.Assert;

public class QuickSort {
    /**
     * Returns a new queue that contains the given queues catenated together.
     *
     * The items in q2 will be catenated after all of the items in q1.
     */
    private static <Item extends Comparable> Queue<Item> catenate(Queue<Item> q1, Queue<Item> q2) {
        Queue<Item> catenated = new Queue<Item>();
        for (Item item : q1) {
            catenated.enqueue(item);
        }
        for (Item item: q2) {
            catenated.enqueue(item);
        }
        return catenated;
    }

    /** Returns a random item from the given queue. */
    private static <Item extends Comparable> Item getRandomItem(Queue<Item> items) {
        int pivotIndex = (int) (Math.random() * items.size());
        Item pivot = null;
        // Walk through the queue to find the item at the given index.
        for (Item item : items) {
            if (pivotIndex == 0) {
                pivot = item;
                break;
            }
            pivotIndex--;
        }
        return pivot;
    }

    /**
     * Partitions the given unsorted queue by pivoting on the given item.
     *
     * @param unsorted  A Queue of unsorted items
     * @param pivot     The item to pivot on
     * @param less      An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are less than the given pivot.
     * @param equal     An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are equal to the given pivot.
     * @param greater   An empty Queue. When the function completes, this queue will contain
     *                  all of the items in unsorted that are greater than the given pivot.
     */
    private static <Item extends Comparable> void partition(
            Queue<Item> unsorted, Item pivot,
            Queue<Item> less, Queue<Item> equal, Queue<Item> greater) {
        // Your code here!
        if (unsorted.isEmpty()) {
            return;
        }
        for (Item item : unsorted) {
            if (pivot.compareTo(item) == 0) {
                equal.enqueue(item);
            } else if (pivot.compareTo(item) > 0) {
                greater.enqueue(item);
            } else {
                less.enqueue(item);
            }
        }
    }

    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> quickSort(
            Queue<Item> items) {
        // Your code here!
        if (items.isEmpty()) {
            return new Queue<>();
        }
        Queue<Item> less = new Queue<>(), greater = new Queue<>(), equal = new Queue<>();
        partition(items, getRandomItem(items), less, equal, greater);
        items = catenate(quickSort(greater), equal);
        items = catenate(items, quickSort(less));
        return items;
    }

    /**
     * Main.
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> students = new Queue<String>();
        Queue<String> sorted = quickSort(students);
//        Assert.assertEquals(new Queue<>(), sorted);
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        sorted = quickSort(students);
        Assert.assertEquals("Alice", sorted.peek());
        sorted.dequeue();
        Assert.assertEquals("Ethan", sorted.peek());
        sorted.dequeue();
        Assert.assertEquals("Vanessa", sorted.peek());

        Queue<Long> integers = new Queue<>();
        integers.enqueue(0L);
        integers.enqueue(0L);
        integers.enqueue(0L);
        integers.enqueue(2L);
        integers.enqueue(3L);
        integers.enqueue(5L);
        integers.enqueue(6L);
        integers.enqueue(7L);
        integers.enqueue(4L);
        integers.enqueue(4L);
        Queue<Long> ints = quickSort(integers);
        Assert.assertEquals(Long.valueOf(0), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(0), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(0), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(2), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(3), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(4), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(4), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(5), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(6), ints.peek());
        ints.dequeue();
        Assert.assertEquals(Long.valueOf(7), ints.peek());
    }
}
