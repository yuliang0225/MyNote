/** Performs some basic array list tests. */
public class ArrayListDeque {
    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
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

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");
//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<String> ald1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, ald1.isEmpty());

        ald1.addFirst("front");
//		lld1.addFirst("Middle");
//		lld1.addLast("last2");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, ald1.size()) && passed;
        passed = checkEmpty(false, ald1.isEmpty()) && passed;

        ald1.addLast("middle");
        passed = checkSize(2, ald1.size()) && passed;

        ald1.addLast("back");
        passed = checkSize(3, ald1.size()) && passed;

        System.out.println("Printing out deque: ");
        ald1.printDeque();
        printTestStatus(passed);

    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

//		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

        ArrayDeque<Integer> ald1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, ald1.isEmpty());

        ald1.addFirst(10);
        ald1.addFirst(26);
        ald1.addFirst(36);

        // should not be empty
        ald1.printDeque();
        passed = checkEmpty(false, ald1.isEmpty()) && passed;
        System.out.println("Removed first.");
        ald1.removeFirst();
        ald1.printDeque();
        System.out.println("Removed last.");
        ald1.removeLast();
        ald1.printDeque();


        ald1.addFirst(10);
        ald1.addFirst(16);
        ald1.addFirst(36);
        ald1.addFirst(10);
        ald1.addFirst(16);
        ald1.addFirst(36);
        ald1.addFirst(10);
        ald1.addFirst(16);
        ald1.addFirst(36);
        ald1.addFirst(10);
        ald1.addFirst(16);
        ald1.addFirst(36);
        ald1.addFirst(10);
        ald1.addFirst(16);
        ald1.addFirst(36);

        ald1.printDeque();
        // Test get
        System.out.println(ald1.get(0));
        System.out.println(ald1.get(2));
        System.out.println(ald1.get(1));
        ald1.printDeque();

        // should be empty
		passed = checkEmpty(true, ald1.isEmpty()) && passed;

        printTestStatus(passed);

    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
    }


}
