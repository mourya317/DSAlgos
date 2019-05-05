package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-04-2019
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {1,2,5,6,9,7,3,2,4};
        int[] arr1 = {4,3,-1,2,-2,10};
        getClosestToX(arr1,0);
    }

    /*
    Find 3 integers in an array whose sum is closest to X              O(N^2)

    approach:  Fix an interger and find the 2 elements whose sum is closest to X - i
     */
    private static void getClosestToX(int[] arr, int X){

        int globali = Integer.MAX_VALUE,globalj=Integer.MAX_VALUE;
        int globalK = Integer.MAX_VALUE;
        //1.sort array
        Arrays.sort(arr);
        int i,j;
        int global_diff  = Integer.MAX_VALUE;
        for(int k=0;k<arr.length;k++){
             i = k+1;
             j = arr.length-1;
             int diff = Integer.MAX_VALUE;

            int locali = Integer.MAX_VALUE,localj=Integer.MAX_VALUE;

             int K = X-arr[k];
             while(i<j){
                 if(arr[i] + arr[j] == K) {
                     locali = arr[i];
                     localj = arr[j];
                     break;
                 }

                 if((arr[i] + arr[j]) > K){
                     //move j fwd
                     j--;
                 }else {
                     i++;
                 }

                 if(Math.abs((arr[i] + arr[j])-K)  < diff){
                     diff = Math.abs((arr[i] + arr[j])-X);
                     locali = arr[i];
                     localj = arr[j];
                 }
             }

             //get global_diff
            int sum =  arr[k]+locali+localj;
             if(Math.abs(sum-X) < global_diff){
                 global_diff = Math.abs(sum-X);
                 globali = locali;
                 globalj = localj;
                 globalK = arr[k];
             }


            System.out.println("iteration "+k+" min values is "+arr[k]+" - "+locali+" - "+localj);
        }
        System.out.println(" values are "+globalK+" - "+globali+" - "+globalj);
    }
}
