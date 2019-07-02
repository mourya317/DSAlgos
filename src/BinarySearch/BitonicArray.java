package BinarySearch;

import sun.security.krb5.internal.crypto.Des;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 10-06-2019
 */
/*
A bitonic array is an array which is initially strectly increading and after some point it is strictly decreasing
 */
public class BitonicArray {
    //Idea is to use Binary search modified
    public static void main(String[] args) {
        int arr[] = {-8, 1, 2, 3, 4, 5, -2, -3};
        int key = -2;
        int n, l, r;
        n = arr.length;
        l = 0;
        r = n - 1;
        int index;
        index = findBitonicPoint(arr, n, l, r);

        int x = searchBitonicArray(arr, n, key, index);

        if (x == -1) {
            System.out.println("Element Not Found");
        } else {
            System.out.println("Element Found at index " + x);
        }

    }




    //First find the bitonic point. in log n
    private static int AscendingBinarySearch(int[] arr, int low, int high, int key){
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                high = mid-1;
            }else if(arr[mid]<key){
                low= mid+1;
            }
        }
        return -1;
    }

    //First find the bitonic point. in log n
    private static int DescendingBinarySearch(int[] arr, int low, int high, int key){
        while(low <= high){
            int mid = low+(high-low)/2;
            if(arr[mid] == key){
                return mid;
            }else if(arr[mid] > key){
                low = mid+1;
            }else if(arr[mid]<key){
                high= mid-1;
            }
        }
        return -1;
    }

    private static int findBitonicPoint(int[] arr, int n, int l, int h){
        int mid = l+(h-l)/2;
        if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid -1 ]){
            return mid;
        }else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]){
            findBitonicPoint(arr, n , mid,h);
        }else if(arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]){
            findBitonicPoint(arr, n , l,mid);
        }

        return mid;
    }


    private static int searchBitonicArray(int[] arr, int n, int key, int biIndex){
        if(key == arr[biIndex])return biIndex;
        if(key > arr[biIndex])return -1;
        int temp = AscendingBinarySearch(arr, 0, biIndex-1,key);
        if(temp != -1)return temp;//Found element
        return DescendingBinarySearch(arr,biIndex+1,n-1,key);
    }


}
