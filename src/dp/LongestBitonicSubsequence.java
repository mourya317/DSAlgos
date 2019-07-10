package dp;

import java.util.LinkedHashSet;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 09-07-2019
 */
public class LongestBitonicSubsequence {
    public static void main(String[] args) {
        System.out.println(lbs(new int[]{1,11,2,10,4,5,2,1}, 8));
    }

    private static int lbs(int[] a, int n){
        //variation of LIS problem, we calculate the lis[i] starting from arr[i] and lds[i] ending with arr[i] are each index and return lds+lis -1

        //find LIS[]
        int LIS[] = new int[n];
        for(int i=0;i<n;i++){
            LIS[i]=1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a[i]>a[j] && LIS[i] < LIS[j]+1){
                    LIS[i]=LIS[j]+1;
                }
            }
        }

        int LDS[] = new int[n];
        for(int i=0;i<n;i++){
            LDS[i]=1;
        }

        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(a[i]>a[j] && LDS[i] < LDS[j]+1){
                    LDS[i]=LDS[j]+1;
                }
            }
        }


        //compute LIS[i]+LDS[i]-1
        int max = LIS[0]+LDS[0]-1;
        for(int i=1;i<n;i++){
            max = Math.max(max, LIS[i]+LDS[i]-1);
        }
        return max;
    }
}
