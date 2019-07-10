package dp;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 02-07-2019
 */
/*

A binomial coefficient C(n, k) can be defined as the coefficient of X^k in the expansion of (1 + X)^n.
A binomial coefficient C(n, k) also gives the number of ways, disregarding order,
that k objects can be chosen from among n objects;
more formally, the number of k-element subsets (or k-combinations) of an n-element set.
c(n,k) = n! / k! * (n-k)!

c(n,k) = c(n-1,k-1) + c(n-1,k)
c(n,0) = c(n,n) = 1

 */
public class BinomialCoe {
    public static void main(String[] args) {
        System.out.println(bicoeDP(5,2));
    }


    private static int bicoeRecursion(int n, int k){
        if(k == n || k ==0)return 1;
        return bicoeRecursion(n-1,k) + bicoeRecursion(n-1,k-1);
    }

//O(n*k)
    private static int bicoeDP(int n, int k){
        int L[][] = new int[n+1][k+1];
        //Fill the array
        for(int i=0;i<=n;i++){
            for(int j=0;j<=k;j++){ //iterate min(i,k)
                if(j==0|| i==j) L[i][j]=1;
                else if(i==0||j==0)L[i][j]=0;
                else L[i][j]= L[i-1][j] + L[i-1][j-1];
            }
        }
        return L[n][k];
    }

    private static int binCoeSpaceOptimised(int n, int k ){
        int C[] = new int[k+1];
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,k);j>0;j--){
                C[j]=C[j]+C[j-1];
            }
        }
        return C[k];
    }
}
