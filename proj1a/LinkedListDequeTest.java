/**
 * @author dunk
 *  Performs some basic linked list tests.
 */
public class LinkedListDequeTest {
	/**
	 * Utility method for printing out empty checks.
	 * @param expected
	 * @param actual
	 * @return
	 */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual
					+ ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/**
	 * Utility method for printing out empty checks.
	 * @param expected
	 * @param actual
	 * @return
	 */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual
					+ ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/**
	 * Utility method for printing out empty checks.
	 * @param expected
	 * @param actual
	 * @return
	 */
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

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
		getTest();
	}
}