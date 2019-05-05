package BinarySearch;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-04-2019
 */
//given sorted array find 2 number that sum upto S
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,9,2,6,0};
        System.out.println(twoSum(arr , 10));
    }

    private static String twoSum(int[] arr, int s) {
        //sort the array
        Arrays.sort(arr);
        int i = 0 ;
        int j = arr.length-1;

        while(i<j){
            if(arr[i] + arr[j] == s) {
                return arr[i] + " - " + arr[j];
            }

            if((arr[i] + arr[j]) > s ){
                //move j fwd
                j--;
            }else {
                i++;
            }

        }
        return "NO";
    }
}
