package dp;

import java.util.Arrays;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 02-07-2019
 */
/*
tabulation - top -down approach  == calculate and store the values in memory whever we solve the problem first time
tabulation - bottom-up approach == we precompute the values to perform lookups later

1.overlappgin subproblems
2.optimal substructe property
 */
public class Fib {
    static long[] fib = new long[100];

    public static void main(String[] args) {
        /*long startTime = System.currentTimeMillis();
        System.out.println(recur(45)); //0 1 1 2 3 5 8   ans = 1134903170
        System.out.println("Time taken for recursion in sec:"+(System.currentTimeMillis() - startTime)/1000l);*/


        /*long startTime1 = System.currentTimeMillis();
        System.out.println(tabulation(45)); //0 1 1 2 3 5 8   ans = 1134903170
        System.out.println("Time taken for recursion in sec:"+(System.currentTimeMillis() - startTime1)/1000l);*/

        long startTime1 = System.currentTimeMillis();
        Arrays.fill(fib,-1);
        System.out.println(memoization(60)); //0 1 1 2 3 5 8   ans = 1134903170
        System.out.println("Time taken for recursion in sec:"+(System.currentTimeMillis() - startTime1)/1000l);
    }

    private static long recur(int n){
        if(n<2)return n;
        return recur(n-1)+recur(n-2);
    }

    // we store the result of recursion in a lookup
    private static long memoization(int n){
        if(fib[n] == -1){
            //compute and cache
            if(n<2) fib[n]=n;
            else fib[n] = memoization(n-1)+memoization(n-2);
        }
        return fib[n];
    }
    // Build bottom up
    private static long tabulation(int n){
        long[] fib = new long[n+1];
        fib[0]=0;
        fib[1]=1;
        for(int i=2;i<=n;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }






}
