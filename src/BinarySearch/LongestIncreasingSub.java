package BinarySearch;

import java.util.ArrayList;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 11-04-2019
 */
public class LongestIncreasingSub {

    public static int max_ref =1;
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        int[] arr1 = {1, 7, 6, 10};
        lis(arr1,arr1.length);
        System.out.println("LIS:"+max_ref);
        System.out.println("LIS DP:"+LIS(arr,arr.length));
        System.out.println("LIS Binary:"+LISBinary(arr,arr.length));
    }

    /*
    naive impl
     */
    /*optimal substructure arr[0...n-1] L(i) is the lenght of the LIS ending at i such that arr[i] is last element of LIS
      L(i) = 1 + max(L(j)) whre 0<j<i and arr[j] < arr[i] or
      L(i) = 1 if no j exists

      for Lis of array we need to find max(L(i)) where 0<i<n
                                                                        }
    */
    private static int lis(int[] arr , int n) {
      //base case
        if(n == 1)
            return 1;

        int max_ending_here = 1; //This is the LIS of arr[n-1]
        int res = 1;
        //recursevely get all LIS ending with arr[0],arr[1]...arr[n-2] and update ma
        for(int i=1;i<n;i++){
            res = lis(arr,i);
            //subproblem
            if(arr[i-1] < arr[n-1] && res+1 > max_ending_here){
                max_ending_here = res+1;
            }
        }

        //compute overall max
        if(max_ref < max_ending_here){
            max_ref=max_ending_here;
        }

        return max_ending_here; // need to return this to previous recursive calls
    }


    /*
    The abv problem has overlapping subproblems we can use memoization for caching previously computed subproblems
    log(n^2)
     */
    private static int LIS(int[] arr, int n){
        int[] lis = new int[n];
        int max=0;
        //initalise all to 1
        for(int i=0;i<n;i++){
            lis[i] =1;
        }

        //compute lis values from bottom up
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && lis[j]+1>lis[i]){
                    //update value of lis[i]
                    lis[i]=lis[j]+1;
                }
            }
        }

        //get max of all lis values
        for(int i=0;i<n;i++){
            if(max<lis[i]){
                max=lis[i];
            }
        }

        return max;

    }

    /*
     select strictly increasing subsequences
     1. if A[i] is smallest among all the end elements of active lists , we create a new active list of length 1
     2. if A[i] is largest among all the end elements , we will clone the largest active list and extend by A[i]
     3. if A[i] is in between, we will find the list with largest end element that is smaller than A[i].
     then Clone and extend this list by A[i], and discard all other lists of same length as that of this modified list

     We will maintain that the end element of the smaller list is always smaller than the end elemtn of the larger lists

     For gettign the length of LIS we need to maintain a auxillary array/list -
     1. adding elemnet to list  = extending the list
     2. replacing an element = discarding list     -   we will

     */
    private static int LISBinary(int[] arr, int n){
        if(arr == null || arr.length == 0 )return 0;

        ArrayList<Integer> list  = new ArrayList<>();
        for(int num:arr){
            if(list.size() == 0 || num > list.get(list.size()-1)){ //1. Adding element
                list.add(num);
            }else {
                //replacing element
                int i=0;
                int j = list.size()-1;

                while(i<j){  // 2. finding the ceiling
                    int mid = (i+j)/2;
                    if(list.get(mid) < num){
                        i=mid+1;
                    }else {
                        j=mid;
                    }
                }
                //replace here after fing hte ceiling
                list.set(j,num);
            }
        }
        return list.size();
    }

}
