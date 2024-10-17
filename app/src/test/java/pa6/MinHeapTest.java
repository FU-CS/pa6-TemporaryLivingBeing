
package pa6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MinHeapTest {

    void testInsert() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);
        assertEquals(1, heap.peek()); 
    }

    @Test
    void testDelete() {
        MinHeap heap = new MinHeap(5);
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);

        assertEquals(1, heap.delete()); 
        assertEquals(2, heap.peek());
        assertEquals(2, heap.delete());
        assertEquals(3, heap.peek());
    }

    @Test
    void testPeek() {
        MinHeap heap = new MinHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertEquals(5, heap.peek());
        heap.insert(1);
        assertEquals(1, heap.peek());
        heap.insert(8);
        assertEquals(1, heap.peek());
    }

    @Test
    void testSize() {
        MinHeap heap = new MinHeap(5);
        assertEquals(0, heap.size());
        heap.insert(5);
        assertEquals(1, heap.size());
        heap.insert(3);
        heap.insert(1);
        assertEquals(3, heap.size());
        heap.delete();
        assertEquals(2, heap.size());
    }

    @Test
    void testIsEmpty() {
        MinHeap heap = new MinHeap(5);
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
        heap.delete();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testPrint() {
        MinHeap heap = new MinHeap(5);

        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        heap.insert(2);

        heap.print();     }
}
