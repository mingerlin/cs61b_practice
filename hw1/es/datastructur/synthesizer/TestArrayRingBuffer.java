package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void Test1() {
        BoundedQueue<Double> arb = new ArrayRingBuffer<>(4);
        assertTrue(arb.isEmpty());      // (returns true)

        arb.enqueue(9.3);    // 9.3
        assertEquals((Double) 9.3, arb.peek());

        arb.enqueue(15.1);   // 9.3  15.1
        arb.enqueue(31.2);   // 9.3  15.1  31.2
        assertFalse(arb.isFull());        // 9.3  15.1  31.2       (returns false)

        arb.enqueue(-3.1);   // 9.3  15.1  31.2  -3.1
        assertTrue(arb.isFull());        // 9.3  15.1  31.2  -3.1 (returns true)

        assertEquals((Double) 9.3, arb.dequeue());       // 15.1 31.2  -3.1       (returns 9.3)
        assertEquals((Double) 15.1, arb.peek());          // 15.1 31.2  -3.1       (returns 15.1)
    }

    @Test
    public void Test2() {
        BoundedQueue<Integer> t2 = new ArrayRingBuffer<>(7);
        assertTrue(t2.isEmpty());      // (returns true)

        t2.enqueue(1);    // 1
        assertEquals((Integer) 1, t2.peek());

        t2.enqueue(2);   // 1 2
        t2.enqueue(3);   // 1 2 3
        assertFalse(t2.isFull());        // 9.3  15.1  31.2       (returns false)

        t2.dequeue();   // 2 3
        t2.dequeue();   // 3
        assertEquals((Integer) 3, t2.peek());          // 3     (returns 3)

        t2.enqueue(4);   // 3 4
        t2.enqueue(5);   // 3 4 5
        t2.enqueue(6);   // 3 4 5 6
        t2.enqueue(7);   // 3 4 5 6 7
        t2.enqueue(8);   // 3 4 5 6 7 8
        t2.enqueue(9);   // 3 4 5 6 7 8 9
        assertTrue(t2.isFull());        // return True
    }

    @Test
    public void Test3() {
        /* this test is aimed to test iterator implemented in ArrayRingBuffer.java
        * use debugger to test */
        BoundedQueue<Integer> t3 = new ArrayRingBuffer<>(9);
        t3.enqueue(1);    // 1
        t3.enqueue(2);   // 1 2
        t3.enqueue(3);   // 1 2 3
        t3.enqueue(4);   // 3 4
        t3.enqueue(5);   // 3 4 5
        t3.enqueue(6);   // 3 4 5 6
        t3.enqueue(7);   // 3 4 5 6 7
        t3.enqueue(8);   // 3 4 5 6 7 8
        t3.enqueue(9);   // 3 4 5 6 7 8 9
        for (int i: t3) {
            System.out.println(t3.dequeue());
        }
    }
}
