package Subarray;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 16-04-2019
 */
/*

 */
public class MaxLengthSubarraySumofK {
    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        System.out.println(manSubArrayLen(arr, 3));
    }


    /*  FAILED
        two pointers starting at l=0,r=0 . move r  when 1. a[l]+a[r] > K else move l
        save the l,r when we encounter sum = K
     */
    private static void maxLenSubarray(int[] arr, int k) {
        int currentSum = arr[0];
        int diff = Integer.MIN_VALUE;
        int gl = 0, gr = 0;
        int l = 0, r = 0;
        while (l < arr.length || r < arr.length) {
            // currentSum += arr[r];
            if (currentSum == k && diff < (r - l)) {
                //save
                gl = l;
                gr = r;
                diff = r - l;
            }
            if (++r < arr.length) {
                //r++; //move r fwrd
                currentSum += arr[r];
            } else {
                //move l
                currentSum -= arr[l];
                l++;
            }
        }
        System.out.println(gl + "-" + gr);
        if (gl == gr) {
            int[] res = Arrays.copyOfRange(arr, gl, gr + 1);
            for (int i = 0; i < res.length; i++)
                System.out.println(res[i]);
        }
    }

    /*
    This is equal to finding a range i,j so sum(num[i]....num[j]) = k
    we need to calculate the prefix sum of each element so, sum(i,j)=sum(j)-sum(i-1) = k . Therefore , for each sum(j)
    if we find there exists a sum(i-1) which equals to sum(j)-k
     */
    private static int manSubArrayLen(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1); // we need to compute sum(j)-sum(i-1)    if i=0 ,this handles the case
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));

            }
        }
        return max;
    }
}
