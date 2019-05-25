package Stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 14-05-2019
 */
public class MovingAvgSlidingWindow {
    public static void main(String[] args) {
        int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int k = 3;

        System.out.println(Arrays.toString(avgSlidingWindow(a, k)));
    }


    public static int[] avgSlidingWindow(int[] arr, int k){

        /*
        Create a queue of size k and calculate the avg and remove dequeue at each iteration
         */

        if(arr.length == 0 || arr ==null) return new int[]{};

        Queue<Integer> queue = new LinkedList<>();

        int sum=0;
        int c=0;
        int[] result = new int[arr.length-k+1];

        for(int i=0;i<k;i++){
            sum+=arr[i];
            queue.offer(arr[i]);
        }

        //first average window
        result[c++] = sum/k;

        //process remaining elements
        for(int i=k;i<arr.length;i++){
            //move the window
            sum = sum - queue.poll();
            sum = sum + arr[i];

            result[c++] = sum/k;
            queue.offer(arr[i]);
        }

        return result;

    }
}
