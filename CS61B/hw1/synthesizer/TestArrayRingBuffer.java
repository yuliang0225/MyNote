package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Shang
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(5);
        assertEquals(false,arb.isFull());
        assertEquals(true,arb.isEmpty());
        assertEquals(5,arb.capacity);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        assertEquals(5,arb.peek());
        assertEquals(5,arb.dequeue());
        assertEquals(6,arb.peek());
        arb.enqueue(8);
        arb.enqueue(9);
        assertEquals(true,arb.isFull());
        assertEquals(false,arb.isEmpty());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
