/**
 * @author dunk
 *  Performs some basic linked list tests.
 */
public class LinkedListDequeTest {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual
                    + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual
                    + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkEqual(int expected, int actual) {
        if (expected != actual) {
            System.out.println("value returned " + actual
                    + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /**
     * Prints a nice message based on whether a test passed.
     * The \n means newline.
     * @param passed
     */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /**
     * Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation.
     */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below "
                + "(and delete this print statement).");
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        printTestStatus(passed);

        lld1.addFirst("front");

        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;
        printTestStatus(passed);

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }

    /**
     * Adds an item, then removes an item,
     * and ensures that dll is empty afterwards.
     */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below "
                + "(and delete this print statement).");
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    public static void getTest() {

        System.out.println("Running get test.");

        System.out.println("Make sure to uncomment the lines below "
                + "(and delete this print statement).");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lst.isEmpty());

        lst.addFirst(1);

        passed = checkSize(1, lst.size()) && passed;

        lst.addFirst(2);

        passed = checkSize(2, lst.size()) && passed;

        lst.addFirst(3);

        passed = checkSize(3, lst.size()) && passed;

        passed = checkEqual(3, lst.get(0)) && passed;
        passed = checkEqual(2, lst.get(1)) && passed;
        passed = checkEqual(1, lst.get(2)) && passed;

        passed = checkEqual(3, lst.getRecursive(0)) && passed;
        passed = checkEqual(2, lst.getRecursive(1)) && passed;
        passed = checkEqual(1, lst.getRecursive(2)) && passed;

        printTestStatus(passed);
    }

    public static void addRemoveIsEmptyTest003() {

        System.out.println("Running get test.");

        System.out.println("addRemoveIsEmptyTest003");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();

        boolean passed = checkEmpty(true, lst.isEmpty());

        lst.addFirst(0);
        passed = checkSize(1, lst.size()) && passed;

        int result = lst.removeLast();
        passed = checkEqual(0, result) && passed;
        passed = checkSize(0, lst.size()) && passed;

        lst.isEmpty();
        passed = checkEmpty(true, lst.isEmpty());

        lst.addFirst(3);
        passed = checkSize(1, lst.size()) && passed;

        result = lst.removeLast();
        passed = checkEqual(3, result) && passed;
        passed = checkSize(0, lst.size()) && passed;

        printTestStatus(passed);

    }

    public static void addRemoveIsEmptyTest005() {

        System.out.println("Running get test.");

        System.out.println("addRemoveIsEmptyTest005");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        boolean passed = checkEmpty(true, lst.isEmpty());
        lst.isEmpty();
        lst.addLast(1);
        passed = checkSize(1, lst.size()) && passed;
        lst.addLast(2);
        passed = checkSize(2, lst.size()) && passed;
        lst.addLast(3);
        passed = checkSize(3, lst.size()) && passed;
        lst.addLast(4);
        passed = checkSize(4, lst.size()) && passed;
        lst.addLast(5);
        passed = checkSize(5, lst.size()) && passed;
        lst.addLast(6);
        passed = checkSize(6, lst.size()) && passed;
        lst.addLast(7);
        passed = checkSize(7, lst.size()) && passed;
        lst.removeFirst();
        passed = checkSize(6, lst.size()) && passed;

        LinkedListDeque<Integer> lst2 = new LinkedListDeque<>();
        lst2.addLast(0);
        passed = checkSize(1, lst2.size());
        lst2.addLast(1);
        passed = checkSize(2, lst2.size());
        lst2.addLast(2);
        passed = checkSize(3, lst2.size());
        int reuslt = lst2.removeFirst();
        passed = checkSize(2, lst2.size());
        passed = checkEqual(0, reuslt);

        printTestStatus(passed);
    }

    public static void addRemoveIsEmptyTest006() {

        System.out.println("Running get test.");

        System.out.println("addRemoveIsEmptyTest006");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        boolean passed = checkEmpty(true, lst.isEmpty());
        lst.addLast(0);
        passed = checkSize(1, lst.size()) && passed;
        lst.addFirst(1);
        passed = checkSize(2, lst.size()) && passed;
        int result = lst.removeLast();
        passed = checkSize(1, lst.size()) && passed;
        passed = checkEqual(0, result);

        LinkedListDeque<Integer> lst2 = new LinkedListDeque<>();
        lst2.isEmpty();
        lst2.size();
        lst2.addLast(2);
        passed = checkSize(1, lst2.size()) && passed;
        lst2.addFirst(3);
        passed = checkSize(2, lst2.size()) && passed;
        result = lst2.removeLast();
        passed = checkSize(1, lst2.size()) && passed;
        passed = checkEqual(2, result);

        printTestStatus(passed);
    }

    public static void getIterative010() {
        System.out.println("Running get test.");

        System.out.println("getIterative010");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        boolean passed = checkEmpty(true, lst.isEmpty());
        lst.addFirst(0);
        passed = checkSize(1, lst.size()) && passed;
        lst.removeLast();
        passed = checkSize(0, lst.size()) && passed;
        lst.addFirst(2);
        passed = checkSize(1, lst.size()) && passed;
        lst.addLast(3);
        passed = checkSize(2, lst.size()) && passed;
        int result = lst.get(1);
        passed = checkEqual(3, result) && passed;


        LinkedListDeque<Integer> lst2 = new LinkedListDeque<>();
        lst2.addFirst(0);
        passed = checkSize(1, lst2.size()) && passed;
        lst2.addLast(1);
        passed = checkSize(2, lst2.size()) && passed;
        result = lst2.removeLast();
        passed = checkSize(1, lst2.size()) && passed;
        passed = checkEqual(1, result) && passed;
        result = lst2.get(0);
        passed = checkEqual(0, result);
        result = lst2.removeFirst();
        passed = checkSize(0, lst2.size());
        passed = checkEqual(0, result);
        lst2.addFirst(5);
        passed = checkSize(1, lst2.size()) && passed;
        result = lst2.removeFirst();
        passed = checkSize(0, lst2.size()) && passed;
        passed = checkEqual(5, result);
        lst2.addLast(7);
        passed = checkSize(1, lst2.size()) && passed;
        result = lst2.get(0);
        passed = checkEqual(7, result) && passed;
        printTestStatus(passed);
    }

    public static void getIterative011() {
        System.out.println("Running get test.");

        System.out.println("getIterative011");

        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        boolean passed = checkEmpty(true, lst.isEmpty());
        lst.addLast(1);
        passed = checkSize(1, lst.size()) && passed;
        lst.removeLast();
        passed = checkSize(0, lst.size()) && passed;
        lst.addLast(3);
        passed = checkSize(1, lst.size()) && passed;
        lst.removeLast();
        passed = checkSize(0, lst.size()) && passed;
        lst.addLast(5);
        passed = checkSize(1, lst.size()) && passed;
        lst.removeFirst();
        passed = checkSize(0, lst.size()) && passed;


        LinkedListDeque<Integer> lst2 = new LinkedListDeque<>();
        lst2.addLast(0);
        passed = checkSize(1, lst2.size()) && passed;
        lst2.addFirst(1);
        passed = checkSize(2, lst2.size()) && passed;
        int result = lst2.getRecursive(0);
        passed = checkEqual(1, result);
        result = lst2.removeLast();
        passed = checkSize(1, lst2.size()) && passed;
        passed = checkEqual(0, result);
        printTestStatus(passed);
    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
        addRemoveIsEmptyTest003();
        addRemoveIsEmptyTest005();
        addRemoveIsEmptyTest006();
        getIterative010();
        getIterative011();
    }
}
