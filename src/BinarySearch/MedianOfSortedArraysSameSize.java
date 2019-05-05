package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 23-02-2019
 */
//Same sized arrays
public class MedianOfSortedArraysSameSize {
    public static void main(String[] args) {
        int[] n1 = {1,12,15,26,38};
        int[] n2 = {2,13,17,30,45};
        //System.out.println(medianOfArrays(n1,n2));
        System.out.println(medianMergeSortCount(n1,n2,n1.length));
        System.out.println(medianUsingBinarySearch(n1,n2,n1.length));
    }


    /*
      approach 1 : count during a merge sort .
      median is the median of n,n-1 of 2n size of merged array
      0(n)
     */
    private static int medianMergeSortCount(int[] n1,int[] n2, int n ){
        int i =0 ;
        int j = 0 ;
        int count = 0 ;
        int m1 = -1 ,m2 = -1;

        for(count = 0 ; count <= n ;count++){

            //handle case where all elements of n1[] are smaller than n2[]
            if(i==n){
                m1=m2;
                m2=n2[0];
                break;
            }

            //handle case where all elements of n2[] are smaller than n1[]
            if(j==n){
                m1=m2;
                m2=n1[0];
                break;
            }


            if(n1[i] < n2[j]){
                //save prev median
                m1 = m2;
                m2 = n1[i];
                i++;
            }else {
                m1 = m2;
                m2 = n2[j];
                j++;
            }
        }
        return (m1+m2)/2;
    }

    /*
    approach 2 :  using the binarysearch to identify the median of 2 arrays
    get median of the arrays using binary search then comparing them
     */
    private static int medianUsingBinarySearch(int[] n1, int[] n2, int n){
        if(n <=0){
            return -1;
        }
        if(n==1){
            return (n1[0]+n2[0])/2;
        }
        if(n==2){
            return (Math.max(n1[0],n2[0])+Math.min(n1[1],n2[1]))/2;
        }

        //get median of n1[]
        int m1 = getMedian(n1,n);
        //get median of n2[]
        int m2 = getMedian(n2,n);

        //if medians are equal
        if(m1==m2)
            return m1;
        //If m1 < m2 , then the median is in n1[m1...] and n2[...m2]
        if(m1<m2){
            if (n % 2 == 0)
                return medianUsingBinarySearch(Arrays.copyOfRange(n1,n/2-1,n), Arrays.copyOfRange(n2,0,n-n/2+1), n - n / 2 + 1);
            return medianUsingBinarySearch(Arrays.copyOfRange(n1,n/2,n), Arrays.copyOfRange(n2,0,n/2+1), n - n / 2);
        }
        //if m1 > m2
        if (n % 2 == 0)
            return medianUsingBinarySearch(Arrays.copyOfRange(n2,n/2-1,n), Arrays.copyOfRange(n1,0,n-n/2+1), n - n / 2 + 1);
        return medianUsingBinarySearch(Arrays.copyOfRange(n2,n/2,n), Arrays.copyOfRange(n1,0,n/2+1), n - n / 2);
    }

    private static int getMedian(int[] n2, int n) {
        //its already sorted array
        if(n%2==0){
            return (n2[n/2-1]+n2[n/2])/2;
        }else{
            return n2[n/2];
        }
    }


    /*
    merge the two arrays and find the median
     */

    private static int medianOfArrays(int[] n1, int[] n2){
        int result=0;
        List<Integer> mergedList =  mergeSortedArray(n1,n2);
        //mergedList.toArray(new Integer[mergedList.size()]);

        int[] merged = mergedList.stream().mapToInt(i->i).toArray();
        //System.out.println("merged:"+merged);
        //find median
        if(merged.length %2 == 0){
            //if even
            result = (merged[merged.length/2] + merged[merged.length/2 - 1 ])/2;
        }else {
            result = merged[merged.length/2]/2;
        }
        return result;
    }

    /*
    O(n1)+0(n2)=0(N1+N2)
     */
    private static List<Integer> mergeSortedArray(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int i=0;
        int j=0;
        List<Integer> res = new ArrayList<>();

        //Move the arr1 pointer until it finds a number greater than arr1 element
        while(i < m && j < n){
            if(arr1[i] < arr2[j]){
                //move the arr1 pointer
                res.add(arr1[i++]);
            }else if(arr1[i] > arr2[j]){
                res.add(arr2[j++]);
            }else{
                //if equal add both and mov both
                res.add(arr1[i++]);
                res.add(arr2[j++]);
            }
        }

        while(i < m){
            res.add(arr1[i++]);
        }

        while(j < n){
            res.add(arr2[j++]);
        }
        return res;
    }
}
