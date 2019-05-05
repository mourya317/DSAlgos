import java.util.ArrayList;
import java.util.List;

public class MergeSortedArray {

    static int[] arr1 = {1,2,5,0,0,0};
    static int[] arr2 = {9,12,15};
    public static void main(String[] args) {
        List<Integer> result = mergeSortedArray(arr1,arr2);
        merge(arr1,arr2);
        /*for(Integer i:result){
            System.out.println(i);
        }*/

        for(int i=0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }
    }


    //in-place merge , loop from backwards and fill A[]
    private static void merge(int[] arr1, int[] arr2){
        int m = arr1.length;
        int n = arr2.length;
        m=m-n;
        while(m > 0 && n > 0){
            if(arr1[m-1] > arr2[n-1]){
                arr1[m+n-1] = arr1[m-1];
                m--;
            }else{
                arr1[m+n-1] = arr2[n-1];
                n--;
            }
        }

        if(n > 0 ){
            arr1[m+n-1] = arr2[n-1];
            n--;
        }

    }


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
