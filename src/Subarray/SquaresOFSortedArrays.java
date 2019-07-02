package Subarray;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 31-05-2019
 */
public class SquaresOFSortedArrays {
    public static void main(String[] args) {

    }

    private static int[] sqSorted(int[] arr){
        if(arr == null)return null;
        if(arr.length == 1)return new int[]{arr[0]^2};

        int s=0;int f=arr.length-1;

        int[] res = new int[arr.length];
        int k =0;

        while(s<f){
            if(Math.abs(arr[s]) > Math.abs(arr[f])){
                res[k++] = (int) Math.pow(arr[s] ,2 );
                s++;
            }else{
                res[k++] = (int) Math.pow(arr[f] ,2 );
                f--;
            }
        }
        return res;
    }

}
