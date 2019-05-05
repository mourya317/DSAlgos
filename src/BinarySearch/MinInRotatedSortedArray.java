package BinarySearch;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 26-03-2019
 */
public class MinInRotatedSortedArray {
    public static void main(String[] args) {
        int[] a = {-2,-1,0,1,2,3};
        int n = a.length;
        System.out.println(getMin(a , 0 , n-1));
    }

    private static int getMin(int[] a, int l, int r){
        //Idea is to do binary search  , split the array
        // compare middle element with leftmost element in the subarray , if it is less then select left subarray
        // if it is greater then select right subarray
        if(l == r){
            //only one element
            return a[l];
        }

        //basic case
        if((r - l) == 1){
            return Math.min(a[l],a[r]);
        }

        int m = l+(r-l)/2;

        if(a[l] < a[r]) { // already sorted and not rotated
            return a[l];

        }
        else if(a[r] == a[l]){ // WITH DUPLICATES
                //case 2. if both are same then drop one of them
                return getMin(a, l+1, m);
            }
        else if(a[m] < a[l]){
            //case 2. select left subarray
            return getMin(a, l, m);
        }else {
            //go right
            return getMin(a, m, r);
        }

    }
}
