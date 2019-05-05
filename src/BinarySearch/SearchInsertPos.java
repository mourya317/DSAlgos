package BinarySearch;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 23-02-2019
 */
public class SearchInsertPos {
    //sorted array is given
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchIndex(nums, 29));
    }

    /*
    binary search the location . O(logn)
     */
    private static int searchIndex(int[] nums , int target) {
        if(target > nums[nums.length-1]){
            return nums.length;
        }
        int l=0;
        int r = nums.length;
        while(l<r){
            int m = l+(r-l)/2;
            if(target>nums[m]){
                l=m+1;
            }else {
                r=m;
            }
        }
        return l;
    }
}
