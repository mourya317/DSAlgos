package Subarray;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 24-04-2019
 */
public class MaxProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        int[] arr1 = {6, -3, -10, 0, 2};
        int[] arr2 = {1, -2, -3, 0, 7, -8, -2};
        System.out.println(maxProductSub(arr2));
    }

    /*
    same as max sum subarray .
    we need to handle a case where a maxproduct can also be found as element * (minimum product ending with prev element)

    track min_ending_here also

     */
    private static int maxProductSub(int[] arr){
        int max_ending_here  =1 ;
        int min_ending_here = 1;
        int max_so_far = 1;

        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                max_ending_here = max_ending_here *arr[i];
                min_ending_here = Math.min(min_ending_here*arr[i] , 1);
            }else if(arr[i] == 0 ){
                //reset
                max_ending_here = 1;
                min_ending_here =1;
            }


            else{
                int temp = max_ending_here;
                max_ending_here = Math.max(min_ending_here*arr[i] , 1);
                min_ending_here = temp*arr[i];
            }
        }

        max_so_far = Math.max(max_so_far , max_ending_here);
        return max_so_far;
    }










    /*
        compute the max_ending_here and max_so_far  (WRONG)
     */
    private static void maxProductSubarray(int[] arr) {
        int max_ending_here = arr[0];
        int max_so_far  = arr[0];
        int start =0 , end = 0 ;
        int beg =0 ;

        for(int i=1;i<arr.length;i++) {
            max_ending_here *= arr[i];

            if (max_ending_here < arr[i]) {
                //reset the max_ending_here
                max_ending_here = arr[i];
                beg = i;  // reset the beginning index
            }

            if (max_so_far < max_ending_here) {
                //update the max
                max_so_far = max_ending_here;
                start = beg;
                end = i;
            }
        }

            //print the subarray
            System.out.println("max: "+max_so_far);

            int[] result = Arrays.copyOfRange(arr,start,end+1);
            for(int r:result){
                System.out.println(r);
            }

        }

    }


