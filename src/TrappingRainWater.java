public class TrappingRainWater {

   /* Given n non-negative integers representing an elevation map
    where the width of each bar is 1, compute how much water it is able to trap after raining.
    time complexity is 0(N)
    space complexity is 0(N)
    */

    static int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    public static void main(String[] args) {
        System.out.println("output:"+findWater(arr.length));

        //optimised for space , since at every element the water trapped is min(max_left,max_right)-arr[i]
        System.out.println("output:"+findWater(arr.length));
    }


    static int findWater1(int n){
        int result = 0;
        int max_left=0;
        int max_right=0;
        int lo=0;
        int hi=n-1;


        //traverse the array
        while(lo<=hi){
            if(arr[lo]<arr[hi]){
                if(arr[lo] > max_left){
                    //update max_left
                    max_left=arr[lo];

                }else {
                    result += max_left - arr[lo];
                }
                lo++;
            }else{
                if(arr[hi] > max_right)
                    //update max_right
                    max_right=arr[hi];
                else
                    result+=max_right-arr[hi];

                hi--;
            }
        }
            return result;
    }


    static int findWater(int n){
        //left[i] contains the height of the tallest bar to the left of
        //ith bar including itself
        int[] left = new int[n];

        //right[i] contains the height of the tallest bar to the right of
        //ith bar including itself
        int[] right = new int[n];

        //initialise water
        int water = 0 ;

        //Fill left array
        left[0] = arr[0];
        for(int i=1;i<n;i++)
            left[i] = Math.max(left[i-1],arr[i]);

        //Fill right array
        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--)
            right[i] = Math.max(right[i+1],arr[i]);

        //calculate acc water
        for(int i=0;i<n;i++)
            water+=Math.min(left[i],right[i])-arr[i];

        return water;
    }
}
