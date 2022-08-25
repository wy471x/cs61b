public class ArrayDequeTest {
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

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list,
     * checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
        System.out.println("Make sure to uncomment the lines below "
                + "(and delete this print statement).");

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());
        printTestStatus(passed);

        lld1.addFirst("front");

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

    /** Adds an item, then removes an item,
     * and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        System.out.println("Make sure to uncomment the lines below "
                + "(and delete this print statement).");
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);
    }


    public static void getTest() {

        System.out.println("Running get test.");

        System.out.println("Make sure to uncomment the lines "
                + "below (and delete this print statement).");

        ArrayDeque<Integer> lst = new ArrayDeque<>();

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

        printTestStatus(passed);
    }

    public static void addSizeTestD001() {

        System.out.println("Running get test.");

        System.out.println("addSizeTest001");

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque1.isEmpty());
        arrayDeque1.addLast(0);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(1);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.size();
        arrayDeque1.addFirst(3);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(4);
        passed = checkSize(4, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(5);
        passed = checkSize(5, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(6);
        passed = checkSize(6, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(7);
        passed = checkSize(7, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(8);
        passed = checkSize(8, arrayDeque1.size()) && passed;

        printTestStatus(passed);

    }

    public static void addFirstRemoveFirstIsEmptyD002() {

        System.out.println("Running get test.");

        System.out.println("addFirstRemoveFirstIsEmptyD002");

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque1.isEmpty());
        arrayDeque1.isEmpty();
        arrayDeque1.addFirst(1);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        int result = arrayDeque1.removeFirst();
        passed = checkSize(0, arrayDeque1.size()) && passed;
        passed = checkEqual(1, result) && passed;
        arrayDeque1.addFirst(3);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(4);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.isEmpty();
        arrayDeque1.addFirst(6);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(7);
        passed = checkSize(4, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeFirst();
        passed = checkSize(3, arrayDeque1.size()) && passed;
        passed = checkEqual(7, result) && passed;
        result = arrayDeque1.removeFirst();
        passed = checkSize(2, arrayDeque1.size()) && passed;
        passed = checkEqual(6, result) && passed;

        printTestStatus(passed);


    }

    public static void addRemoveIsEmptyD004() {
        System.out.println("Running get test.");

        System.out.println("addRemoveIsEmpty004");

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();

        arrayDeque1.addLast(0);
        boolean passed = checkSize(1, arrayDeque1.size());
        arrayDeque1.addLast(1);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(2);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(3);
        passed = checkSize(4, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(4);
        passed = checkSize(5, arrayDeque1.size()) && passed;

        printTestStatus(passed);
    }

    public static void addLastRemoveFirstIsEmptyTestD005() {
        System.out.println("Running get test.");

        System.out.println("addLastRemoveFirstIsEmptyTest005");

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque1.isEmpty());
        arrayDeque1.addLast(0);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        int result = arrayDeque1.removeFirst();
        passed = checkSize(0, arrayDeque1.size()) && passed;
        passed = checkEqual(0, result);
        arrayDeque1.addLast(2);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(3);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(4);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(5);
        passed = checkSize(4, arrayDeque1.size()) && passed;

        printTestStatus(passed);

    }

    public static void getTestD011() {

        System.out.println("Running get test.");

        System.out.println("getTest011");

        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque1.isEmpty());

        arrayDeque1.addFirst(0);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        int result = arrayDeque1.removeFirst();
        passed = checkSize(0, arrayDeque1.size()) && passed;
        passed = checkEqual(0, result) && passed;
        arrayDeque1.addLast(2);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(3);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(4);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeFirst();
        passed = checkSize(2, arrayDeque1.size()) && passed;
        passed = checkEqual(3, result) && passed;
        arrayDeque1.addLast(6);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeFirst();
        passed = checkSize(2, arrayDeque1.size()) && passed;
        passed = checkEqual(2, result) && passed;
        result = arrayDeque1.get(1);
        passed = checkEqual(6, result) && passed;
        result = arrayDeque1.get(0);
        passed = checkEqual(4, result) && passed;
        arrayDeque1.addLast(10);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(11);
        passed = checkSize(4, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(12);
        passed = checkSize(5, arrayDeque1.size()) && passed;
        result = arrayDeque1.get(3);
        passed = checkEqual(6, result) && passed;
        arrayDeque1.addFirst(14);
        passed = checkSize(6, arrayDeque1.size()) && passed;
        result = arrayDeque1.get(2);
        passed = checkEqual(11, result) && passed;
        result = arrayDeque1.get(0);
        passed = checkEqual(14, result) && passed;
        arrayDeque1.addFirst(17);
        passed = checkSize(7, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(18);
        passed = checkSize(8, arrayDeque1.size()) && passed;

        printTestStatus(passed);

    }

    public static void getTestD011N2() {
        System.out.println("Running get test.");
        System.out.println("getTestD011N2");
        ArrayDeque<Integer> arrayDeque2 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque2.isEmpty());
        arrayDeque2.addLast(0);
        passed = checkSize(1, arrayDeque2.size()) && passed;
        int result = arrayDeque2.removeFirst();
        passed = checkSize(0, arrayDeque2.size()) && passed;
        passed = checkEqual(0, result) && passed;
        arrayDeque2.addLast(2);
        passed = checkSize(1, arrayDeque2.size()) && passed;
        arrayDeque2.addFirst(3);
        passed = checkSize(2, arrayDeque2.size()) && passed;
        arrayDeque2.addLast(4);
        passed = checkSize(3, arrayDeque2.size()) && passed;
        result = arrayDeque2.get(0);
        passed = checkEqual(3, result) && passed;
        result = arrayDeque2.get(0);
        passed = checkEqual(3, result) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkSize(2, arrayDeque2.size()) && passed;
        passed = checkEqual(3, result) && passed;
        arrayDeque2.addLast(8);
        passed = checkSize(3, arrayDeque2.size()) && passed;
        arrayDeque2.addLast(9);
        passed = checkSize(4, arrayDeque2.size()) && passed;
        result = arrayDeque2.get(1);
        passed = checkEqual(4, result) && passed;
        arrayDeque2.addLast(11);
        passed = checkSize(5, arrayDeque2.size()) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkSize(4, arrayDeque2.size()) && passed;
        passed = checkEqual(2, result) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkSize(3, arrayDeque2.size()) && passed;
        passed = checkEqual(4, result) && passed;
        arrayDeque2.addFirst(14);
        passed = checkSize(4, arrayDeque2.size()) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkSize(3, arrayDeque2.size()) && passed;
        passed = checkEqual(14, result) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkSize(2, arrayDeque2.size()) && passed;
        passed = checkEqual(8, result) && passed;
        arrayDeque2.addLast(17);
        passed = checkSize(3, arrayDeque2.size()) && passed;
        result = arrayDeque2.get(2);
        passed = checkEqual(17, result) && passed;
        result = arrayDeque2.removeLast();
        passed = checkSize(2, arrayDeque2.size()) && passed;
        passed = checkEqual(17, result) && passed;
        result = arrayDeque2.get(1);
        passed = checkEqual(11, result) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkEqual(9, result) && passed;
        result = arrayDeque2.removeFirst();
        passed = checkEqual(11, result) && passed;
        printTestStatus(passed);
    }

    public static void getTestD011N3() {
        System.out.println("Running get test.");
        System.out.println("getTestD011N3");
        ArrayDeque<Integer> arrayDeque1 = new ArrayDeque<>();
        boolean passed = checkEmpty(true, arrayDeque1.isEmpty());
        arrayDeque1.addLast(0);
        passed = checkSize(1, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(1);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        int result = arrayDeque1.removeLast();
        passed = checkSize(1, arrayDeque1.size()) && passed;
        passed = checkEqual(1, result) && passed;
        arrayDeque1.addLast(3);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeLast();
        passed = checkSize(1, arrayDeque1.size()) && passed;
        passed = checkEqual(3, result) && passed;
        arrayDeque1.addFirst(5);
        passed = checkSize(2, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(6);
        passed = checkSize(3, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(7);
        passed = checkSize(4, arrayDeque1.size()) && passed;
        arrayDeque1.addLast(8);
        passed = checkSize(5, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(9);
        passed = checkSize(6, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeFirst();
        passed = checkSize(5, arrayDeque1.size()) && passed;
        passed = checkEqual(9, result) && passed;
        arrayDeque1.addFirst(11);
        passed = checkSize(6, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(12);
        passed = checkSize(7, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(13);
        passed = checkSize(8, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeLast();
        passed = checkSize(7, arrayDeque1.size()) && passed;
        passed = checkEqual(8, result) && passed;
        arrayDeque1.addLast(15);
        passed = checkSize(8, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(16);
        passed = checkSize(9, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(17);
        passed = checkSize(10, arrayDeque1.size()) && passed;
        arrayDeque1.addFirst(18);
        passed = checkSize(11, arrayDeque1.size()) && passed;
        result = arrayDeque1.removeLast();
        passed = checkSize(10, arrayDeque1.size()) && passed;
        passed = checkEqual(15, result) && passed;
        printTestStatus(passed);
    }



    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        getTest();
        addSizeTestD001();
        addRemoveIsEmptyD004();
        addLastRemoveFirstIsEmptyTestD005();
        getTestD011();
        addFirstRemoveFirstIsEmptyD002();
        getTestD011N2();
        getTestD011N3();
    }
}
