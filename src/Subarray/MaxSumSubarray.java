package Subarray;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 16-04-2019
 */
public class MaxSumSubarray {
    public static void main(String[] args) {
        int[] arr = {1, -2, 1, 1, -2, 1};
        int[] arr2 = {0, -2, -3,12,-1};
        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr3 = {-2,1, -3 ,4, -1,2,1,-5,4};
        maxSumSubarray(arr2);
        maxSumSubarrayWorksAllCases(arr3);
    }

    /*
    idea is to iterate the array ,  move the r pointer if sum is 0 shift left pointer O(N)
    k-dane algorithm  works only when atleast one element is positive
     */
    private static void maxSumSubarray(int[] arr){
        int l =0 , r=0;
        int sum =0;
        int globalMax  =0 , gl = 0 ,gr = 0 ;
        while(r < arr.length){
            if((sum + arr[r]) > 0 ){
                sum+=arr[r];
                if(globalMax < sum){
                    globalMax = sum;
                    gl = l;
                    gr =r ;
                }
                r++;
            }else{
                //move left pointer and reset sum
                r++;
                l=r;
                sum=0;
            }
        }
        System.out.println("sum is "+globalMax);
        int[] result = Arrays.copyOfRange(arr,gl,gr+1);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }


    /*
    max_so_far is not 0 but a[0] and curr_max is arr[0]  . This is 0(N) and space is 0(1)
     */
    private static void maxSumSubarrayWorksAllCases(int[] arr){
        int l =0 , beg=0;
        int max_ending_here = arr[0];
        int max_so_far  = arr[0] , start = 0 ,end = 0;
        for(int i=1;i<arr.length;i++) {

            max_ending_here += arr[i]; // update max sum of subarray ending at r

            if (max_ending_here < arr[i]) {
                max_ending_here = arr[i]; //empty subarray
                beg = i;
            }

            //update result if current subarray is >
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = beg;
                end = i;
            }
        }

        System.out.println("sum is "+max_so_far);
        int[] result = Arrays.copyOfRange(arr,start,end+1);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }

    /*
    Using sum diff to find maximum difference. calculate the max_ending at each place and put the value in queue(wic remembers min sum at the head of the queue)
    0(nlogn) = n * log(n) ,space is 0(n)
     */
    private static int maxSubArrayUsingSumDiff(int[] arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        int sum =0;
        int result = Integer.MIN_VALUE;

        PriorityQueue<Integer> pre = new PriorityQueue<>();
        pre.offer(0);

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            //update result to maximize the (sum-sum')
            result = Math.max(result, sum - pre.peek());
            pre.offer(sum); //This takes log(n) for inserting into PQ
        }
        return result;
    }
}
