package Heaps;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 04-05-2019
 */
public class MinIntHeap {
    private int capacity = 10;
    private int size = 0 ;

    int[] items = new int[capacity];

    private int getLeftChildIndex(int parentIndex){return parentIndex*2+1; }
    private int getRightChildIndex(int parentIndex){return parentIndex*2+2; }
    private int getParentIndex(int childIndex){return (childIndex-2)/2; }

    private boolean hasLeftChild(int parentIndex){return getLeftChildIndex(parentIndex) < size; }
    private boolean hasRightChild(int parentIndex){return getRightChildIndex(parentIndex) < size; }
    private boolean hasParent(int index){return getParentIndex(index) >= 0; }

    private int leftChild(int parentIndex){return items[getLeftChildIndex(parentIndex)];}
    private int rightChild(int parentIndex){return items[getRightChildIndex(parentIndex)];}
    private int parent(int childIndex){return items[getParentIndex(childIndex)];}


    public void swap(int index1, int index2){
        int temp = items[index2];
        items[index2] = items[index1];
        items[index1] = temp;
    }

    public void ensureExtraCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity*=2;
        }
    }

    public int peek() throws IllegalAccessException {
        if(size == 0 ) throw new IllegalAccessException("Heap is empty");
        return items[0];
    }

    public int poll() throws IllegalAccessException {
        if(size == 0 ) throw new IllegalAccessException("Heap is empty");
        //copy last element here and heapifyDown
        int item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;

    }

    public void add(int item){
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && parent(index) > items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0 ;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) < leftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index] < items[smallerChildIndex]){
                break;
            }else{
                swap(smallerChildIndex, index);
            }
            index = smallerChildIndex;
        }
    }
}

