package Stream;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 14-05-2019
 */
/*
Find the max of all subarrays of size k
 */
public class SlidingWindowMaximum {
    // approach 1 is using max heap . put k elements in heap and poll first element  and repeat

    public static void main(String[] args) {
        int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int k = 3;

        System.out.println(Arrays.toString(slidingMaximum(a, k)));
        System.out.println("---------------------");
        System.out.println(Arrays.toString(maxSlidingDeque(a, k)));
    }

    public static int[] slidingMaximum(int[] arr, int k){
        if(arr==null || arr.length == 0 ) return new int[]{};

        int count=0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }) ;


        int[] result = new int[arr.length - k+1];
        for(int i=0;i<arr.length-k+1;i++){

            for(int j=i;j<i+k;j++){
                //put in heap
                maxHeap.offer(arr[j]);
            }

            //remove the lasgest of the heap (window)
            Integer element = maxHeap.poll();
            result[count++] = element;

            // clear heap
            maxHeap.clear();

        }


        return result;


    }


    public static int[] maxSlidingDeque(int[] arr, int k ){
        // Create a Double Ended Queue, Qi that will store indexes of array elements
        // The queue will store indexes of useful elements in every window and it will
        // maintain decreasing order of values from front to rear in Qi, i.e.,
        // arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> Qi = new LinkedList<Integer>();

        int[] result = new int[arr.length-k+1];
        int c=0;

        //process first k elements in array
        for(int i=0;i<k;i++){
            //remove from rear
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]){
                Qi.removeLast();
            }


            Qi.addLast(i);
        }


        //process rest of the array
        for(int i=k;i<arr.length;i++){

            result[c++] = arr[Qi.peek()];

            //remove the eleemnts out of the deque
            while(!Qi.isEmpty() && Qi.peekFirst() <= i-k){
                Qi.removeFirst();
            }

            //remove elements smaller than currently being added element
            while(!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()] ){
                Qi.removeLast();
            }


            Qi.addLast(i);
        }

        //max element of last window
        result[c++] = arr[Qi.peek()];


        return result;



    }
}
