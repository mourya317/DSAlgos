package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 18-05-2019
 */


public class BucketSort {
    public static void main(String[] args) {


        float[] arr = {0.897f, 0.565f, 0.656f, 0.1234f, 0.665f, 0.3434f};
        float[] arr1 = {12,13,1,6,9,34};
        bucketSort(arr);
    }

    /*
    used when a input is distributed uniformly over a range.
    o(N) .
    we distribute elements into a bucket and sort each bucket using insertion sorting and then merge them
     */
    public static void bucketSort(float[] arr){
        //create n buckets . each bucket is a list<Integer>
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];
        //initialise
        for(int i=0;i<buckets.length;i++){
            buckets[i] = new ArrayList<>();
        }


        //float max = Arrays.stream(arr).max()
        //insert into buckets
        for(int i=0;i<n;i++){
            /*double interval = (double) arr.length / (max - min);
            int index = (int) ((num[i] - min) * interval);*/    //distribute with intervals

            buckets[(int) (n*arr[i])].add(arr[i]);
        }

        //sort each bucket
        for(int i=0;i<n;i++){
            Collections.sort(buckets[i]);
        }

        //merge the buckets
        int k=0;
        for(int i=0;i<buckets.length;i++){
            List<Float> bucket = buckets[i];
            int b = 0;
            while(b < bucket.size() ){
                arr[k++] = bucket.get(b++);
            }
        }


        //print the arr
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }

    }

    void insertion_sort ( int A[ ] , int n)
    {
        for( int i = 0 ;i < n ; i++ ) {
    /*storing current element whose left side is checked for its
             correct position .*/

            int temp = A[ i ];
            int j = i;

       /* check whether the adjacent element in left side is greater or
            less than the current element. */

            while(  j > 0  && temp < A[ j -1]) {

                // moving the left side element to one position forward.
                A[ j ] = A[ j-1];
                j= j - 1;

            }
            // moving current element to its  correct position.
            A[ j ] = temp;
        }


    }

}
