package DFS;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 11-06-2019
 */
/*
Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 */
public class PartitionKEqualSubsets {

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4,3,2,3,5,2,1},4));
    }


    private static boolean canPartitionKSubsets(int[] nums, int k ){
        int sum =0;
        for(int num:nums){
            sum+=num;
        }

        if(sum %k!=0){
            return false;
        }

        int share = sum/k;

        Arrays.sort(nums);
        int j = nums.length-1;
        if(nums[j] > share){
            return false;
        }

        while(j>=0 && nums[j] ==share){
            j--;
            k--;
        }


        int[] buckets = new int[k];
        return helper(j,nums,share,buckets);

    }

    //put jth number to each bucket and recurselvely search
    //Backtrack and search
    private static boolean helper(int j, int[] nums, int share, int[] buckets) {
        if(j<0)return true;

        for(int i=0;i<buckets.length;i++){
            if(buckets[i] + nums[j] <=share){
                //choose
                buckets[i]+=nums[j];
                //Recurse remaining
                if(helper(j-1,nums,share,buckets)){
                    return true;
                }
                //unchoose
                buckets[i]-=nums[j];
            }

            //if(buckets[i] == 0 ) break;
        }
        return false;
    }
}
