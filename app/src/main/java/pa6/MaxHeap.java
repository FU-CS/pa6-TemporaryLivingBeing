package pa6;

import java.util.Arrays;

// Uncomment the following class to get started
// Implement all methods in the Heap interface

public class MaxHeap implements Heap {

    int[] data;
    private int maxCapacity;
    private int size = 0;
    public MaxHeap(int capacity){
         this.maxCapacity = capacity;
         this.data = new int[this.maxCapacity];
     }
     /**
     * Inserts a value into the heap
     * For a max heap, the value is inserted at the end of the heap and then bubbled up
     * For a min heap, the value is inserted at the end of the heap and then bubbled up
     * @param value
     */ 
    public void insert(int value){
        if (this.size >= this.maxCapacity){
            return;
        }
        this.data[this.size] = value;
        this.size += 1;
        this.heapify();
    }

    private void swap(int i, int j){
        int tmp = this.data[i];
        this.data[i] = this.data[j];
        this.data[j] = tmp;
    }

    /**
     * Deletes the root of the heap
     * For a max heap, the root is replaced with the last element in the heap and then bubbled down
     * For a min heap, the root is replaced with the last element in the heap and then bubbled down
     * @return
     */
    public int delete(){
        if (this.size <= 0){
            return -1;
        }
        
        size -= 1;
        this.swap(0, size);
        this.deleteHelper();
        return this.data[this.size];
    }

    private void heapify() {
        int i = this.size - 1;
        while (i > 0) {
            int parentidx = (i - 1) / 2;
            int parent = this.data[parentidx];
    
            if (this.data[i] > parent) {
                this.swap(parentidx, i);
            }
            i = parentidx;
        }
    }
    
    private void deleteHelper() {
        int i = 0;
        while (i * 2 + 1 < this.size) {
            int leftChildIdx = i * 2 + 1;
            int rightChildIdx = i * 2 + 2;
    
            int largerChildIdx = leftChildIdx;
    
            if (rightChildIdx < this.size && this.data[rightChildIdx] > this.data[leftChildIdx]) {
                largerChildIdx = rightChildIdx;
            }
    
            if (this.data[i] >= this.data[largerChildIdx]) {
                return; 
            }
    
            this.swap(largerChildIdx, i);
            i = largerChildIdx;
        }
    }
    /**
     * Returns the root of the heap
     * @return
     */
    public int peek(){
        return this.data[0];
    }
    /**
     * Returns the size of the heap. 
     * The size is the number of elements / nodes in the heap
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * Returns whether the heap is empty
     * @return
     */
    public boolean isEmpty(){
        return this.size < 1;
    }

    /** 
     * Prints the heap in level order
     */
    public void print(){
        for (int i = 0; i < this.size; i++){
            System.out.print(this.data[i] + " ");
        }
    }
    /**
     * Sorts an unsorted array using a heap
     * For a max heap, the array is first converted to a max heap and then sorted in descending order
     * For a min heap, the array is first converted to a min heap and then sorted in ascending order
     * 
     * Create a new heap and insert each element from the array into the heap 
     * instead of changing the object's heap array
     * 
     * Your implementation must have time complexity: O(n log n) 
     * and space complexity: O(n)
     * 
     * @param array
     */
    static int[] heapSort(int[] array){
        MaxHeap maxHeap = new MaxHeap(array.length);
    
        for (int i = 0; i < array.length; i++) {
            maxHeap.insert(array[i]);
        }
    
        int[] sortedArray = new int[array.length];
    
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = maxHeap.delete();
        }
    
        return sortedArray;
    }

}
