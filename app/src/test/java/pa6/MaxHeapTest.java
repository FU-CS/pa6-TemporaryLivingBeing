
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MaxHeapTest {

@Test
    void testInsert() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(8, heap.peek());
    }

    @Test
    void testDelete() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        heap.print();
        assertEquals(8, heap.delete());
        heap.print();
        assertEquals(5, heap.peek());
        assertEquals(5, heap.delete());
        assertEquals(3, heap.peek());
    }
    @Test
    void testDuplicate() {
        MaxHeap heap = new MaxHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(3);
        heap.insert(1);
        heap.insert(2);
        heap.print();
        assertEquals(5, heap.delete());
        heap.print();
        
        assertEquals(3, heap.peek());
        assertEquals(3, heap.delete());
        assertEquals(3, heap.peek());
    }
    @Test
    void testPeek() {
        MaxHeap heap = new MaxHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertEquals(5, heap.peek());
        heap.insert(10);
        assertEquals(10, heap.peek());
        heap.insert(3);
        assertEquals(10, heap.peek());
    }

    @Test
    void testSize() {
        MaxHeap heap = new MaxHeap(5);
        assertEquals(0, heap.size());
        heap.insert(5);
        assertEquals(1, heap.size());
        heap.insert(3);
        heap.insert(8);
        assertEquals(3, heap.size());
        heap.delete();
        assertEquals(2, heap.size());
    }

    @Test
    void testIsEmpty() {
        MaxHeap heap = new MaxHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
        heap.delete();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testPrint() {
        MaxHeap heap = new MaxHeap(5);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);

        heap.print();
    }
}