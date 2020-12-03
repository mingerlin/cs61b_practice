import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test cases for the ArrayDeque Test.
 * @author Minger Lin
 */

public class ArrayDequeTest {

    /** This test is meant to check addFirst() and addLast() */
    @Test
    public void test1() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(2);
        array.addLast(3);
        assertEquals(array.get(0), (Integer) 2);
        assertEquals(array.get(1), (Integer) 3);

        array.addFirst(1);
        assertEquals(array.get(2), (Integer) 3);

        array.addFirst(6);
        assertEquals(array.get(0), (Integer) 6);

        array.addLast(7);
        array.addLast(8);
        array.addFirst(5);
        assertEquals(7, array.size());
        assertEquals(array.get(0), (Integer) 5);
        assertEquals(array.get(6), (Integer) 8);
    }

    /** This test is meant to check isEmpty(), removeLast() and get() */
    @Test
    public void test2() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(0);
        assertFalse(array.isEmpty());
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.removeLast();
        assertEquals(array.get(3), (Integer)4);
        array.removeLast();
        assertNull(array.get(3));
    }

    /** This test is meant to check all methods*/
    @Test
    public void test3() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        assertTrue(array.isEmpty());
        for (int i = 1; i < 11; i++) {
            array.addLast(i);
        }
        assertFalse(array.isEmpty());
        array.addFirst(0);
        array.addFirst(1);
        array.removeFirst();
        assertEquals(array.get(0), (Integer)0);
        assertEquals(array.size(), 11);
        assertNull(array.get(11));
    }

    /** This test is meant to check resizing */
    @Test
    public void test4() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        array.addFirst(2);
        array.addLast(3);
        Integer[] testArr1 = new Integer[]{2, 3};
        assertEquals(array.get(0), (Integer) 2);
        assertEquals(array.get(1), (Integer) 3);

        array.addFirst(1);
        assertEquals(array.get(2), (Integer) 3);

        array.addFirst(6);
        assertEquals(array.get(0), (Integer) 6);

        array.addLast(7);
        array.addLast(8);
        array.addFirst(5);
        array.addLast(4);
        array.addFirst(9);
        assertEquals(9, array.size());
        assertEquals(array.get(0), (Integer) 9);
        assertEquals(array.get(8), (Integer) 4);
    }
}