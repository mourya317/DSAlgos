package Subarray;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 16-04-2019
 */
/*
Find 2 integers whose sum is the target
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        twoSum(arr,9);
        twoSumHM(arr,9);
    }

    /*
    first sort the array
    idea is to get two pointers l , r . If sum is higher move right pointer else move left pointer
  nlogn
     */
    private static void twoSum(int[] arr , int x){
        Arrays.sort(arr);//(nlogn)

        int l = 0,r=arr.length-1;
        while(l<r){
            int sum = arr[l]+arr[r];
            if(sum == x){
                System.out.println(arr[l]+"-"+arr[r]);
                return;
            }
            if(sum > x){
                //move right pointer
                r--;
            }else{
                l++;
            }
        }
    }


    /*
    o(n)
    use hashmap to store key as target - element  and value as that number , then iterate and if that key is found in hashmap ,we got the other number
     */
    private static void twoSumHM(int[] arr, int x){
        HashMap hm = new HashMap();
        for(int i =0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                //we found the other number
                System.out.println(arr[i] + "-"+ hm.get(arr[i]));
                return;
            }
            hm.put(x-arr[i] , arr[i]);
        }
    }
}
