package BinarySearch;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 19-07-2019
 */
public class PrefixSumArray {
    /*
    It has many applications
     */

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3,4};
        int[] pSum = prefSum(arr);


        //Applications
        /*
        1. Find the max subarray size such that all subarrays of that size has sum less than k
        2. Find a subarry with sum 0

Input :  arr[] = {1, 2, 3, 4} and k = 8.
Output : 2
Sum of subarrays of size 1: 1, 2, 3, 4.
Sum of subarrays of size 2: 3, 5, 7.
Sum of subarrays of size 3: 6, 9.
Sum of subarrays of size 4: 10.
So, maximum subarray size such that all subarrays
of that size have sum of elements less than 8 is 2.

         */

        int arr1[] = { 1, 2, 10, 4 };
        int n = arr1.length;
        int k = 14;
        System.out.println(maxSizek(arr1, k));


    }

    private static int[] prefSum(int[] arr){
        int[] prefixSum = new int[arr.length+1];
        Arrays.fill(prefixSum,0);
        prefixSum[0]=arr[0];
        for(int i=0;i<arr.length;i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        return prefixSum;
    }

    private static int maxSizek(int[] arr , int k){
        int[] preSum = prefSum(arr);

        //Do binary search of the max size of subarrays with sum < k
        return bsearch(arr,preSum, k);
    }

    //Search the array sizes 1..n
    private static int bsearch(int[] arr, int[] preSum, int k) {
        int n = arr.length;
        int ans=-1;
        int left = 1; int right = n ;
        while(left <= right){
            int mid = (right + left )/2;
            //chek all subarrays of size mid after i
            int i;
            for(i=mid;i<=arr.length;i++){
                if(preSum[i]  - preSum[i - mid] > k)
                    break;
            }

            if(i == n+1){ // It passes the te4st for 1...n sizes
                ans = mid;
                left = mid+1;
            }else {
                right = mid-1;
            }

        }
        return ans;
    }


}
