import java.util.Arrays;

public class MinSizeSubArraySum {
    /*
    Given an array of n positive integers and a positive integer s,
    find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
    For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3]
    has the minimal length of 2 under the problem constraint.
     */



    /*
    We can use 2 points to mark the left and right boundaries of the sliding window.
     When the sum is greater than the target, shift the left pointer;
      when the sum is less than the target, shift the right pointer


      Find the max length of subarray by moving the right pointer to correct position then
      shorten the window by moving the left pointer.
     */
    static int[] arr = {2,3,1,2,4,3};
    public static void main(String[] args) {
        int[] sol = solution(7);
        for(int i=0;i<sol.length;i++)
            System.out.println(sol[i]);

    }

    private static int[] solution(int s) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] resultArray = {};

        /*for(int i=0;i<arr.length;i++)
            sum+=arr[i];
*/
        while(r<arr.length){

            if(sum < s){  //sum < target , move right pointer
                sum+=arr[r];
                r++;
            }else{
                //save the min length of the subarray
                if((r-l) < minLen){
                    minLen = r-l;
                    resultArray = Arrays.copyOfRange(arr,l,r+1);
                }
                //check if length of 2 is obtained
                if(l==r-1)
                    return resultArray;

                sum-=arr[l];
                l++;

            }

        }

        while(sum >=s){
            minLen=Math.min(minLen,r-l);
            sum-=arr[l++];
            //resultArray = Arrays.copyOfRange(arr,l,r+1);
        }

        return resultArray;
    }

}
