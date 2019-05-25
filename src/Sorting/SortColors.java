package Sorting;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-05-2019
 */
/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 */
public class SortColors {
    /*
    use counting sort
     */

    public static void main(String[] args) {

        int[] nums = {0,1,2,0,0,2,2,2,0,2,1,1};
        int[] nums1 = {-5, -10, 0, -3, 8, 5, -1, 10};
        countingSort(nums1);


    }


    public static void sort(){
        int[] count = new int[3];
        int[] nums = {0,1,2,0,0,2,2,2,0,2,1,1};
        int[] result = new int[nums.length];

        //fill array


        for(int i = 0;i< nums.length;i++){
            count[nums[i]]++;
        }

        int j=0;
        for(int i=0;i<count.length;i++){
            int c = count[i];
            while(c-- > 0 ){
                result[j++] = i;
            }
        }


        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }


    public static void countingSort(int[] nums){
        /*
        1. create a count array
        2. modify the count array to contain actual position of element in sorted array
        3. Build the output array
        0(n + k )    where k is the range , n is the length of array

        Radix sort is also like counting sort - we do counting sort for each significant digit starting
         from the lowest to highest(get maxx element from the array)

         The complexity is O(n + b ) logb(maxx) === O(n * logb(n))
         */

        int[] result = new int[nums.length];
        //range is 3(k=3)
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int range = max - min +1;
        int[] count = new int[range];
        for(int i = 0;i< nums.length;i++){
            count[nums[i] - min ]++;
        }


        //modify the count array
        for(int i = 1;i< count.length;i++){
            count[i] = count[i-1]+count[i];
        }

        //Build the output array
        for(int i = 0;i< nums.length;i++){
            result[count[nums[i] - min ]-1] = nums[i];
            --count[nums[i] - min ];
        }

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }


}
