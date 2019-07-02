package dp;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 02-07-2019
 */
public class EditDistance {
    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "cart";
        String s2 = "march";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of edit distance is" + " " +
                editDistanceDP( X, Y, m, n ) );
    }

    //Return edit distance if X[0..m-1] and Y[0..n-1]
    /*
    2 cases: i. if last char is equal then find L1[m]L2[n] = 1 + editDistance( L1[m-1]L2[n-1])
             ii. if not then L1[m]L2[n] = 1 + min(L1[m-1]L2[n-1], L1[m-1]L2[n] , L1[m]L2[n-1]);
             O(3^m)
     */
    private static int editDistance(char[] x, char[] y, int m, int n){
        if(m==0||n==0)return 0;
        if(x[m-1]==y[n-1])return editDistance(x,y,m-1,n-1);
        else return 1 + Math.min(editDistance(x,y,m-1,n-1),Math.min(editDistance(x,y,m-1,n), editDistance(x,y,m,n-1)));
    }


    //O(M*N)
    private static int editDistanceDP(char[] x, char[] y, int m, int n){
        int L[][] = new int[m+1][n+1];
        //fill the table
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)L[i][j]=Math.max(i,j);
                /*if(i==0)L[i][j]=j;
                else if(j==0)L[i][j]=i;*/
                else if(x[i-1]==y[j-1]) L[i][j]= L[i-1][j-1];
                else L[i][j] = 1 + Math.min(L[i-1][j-1], Math.min(L[i][j-1],L[i-1][j]));
            }

        }
        return L[m][n];
    }


}
