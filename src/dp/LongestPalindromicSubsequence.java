package dp;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 08-07-2019
 */
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        //String s = "GEEKSFORGEEKS";
        String s = "BBABCBCAB";
        System.out.println(LPSdp(s,s.length()));
    }

    // O(2^n)
    private static int LPS(String s, int b, int e){
        if(b==e)return 1;
        if(b>e)return 0;
        if(e-b == 1 ){
            if(s.charAt(e) == s.charAt(b)){
                return 2;
            }
        }
        if(s.charAt(b)==s.charAt(e)){
            return 2+LPS(s,b+1,e-1);
        }

        return Math.max(LPS(s,b+1,e),LPS(s,b,e-1));
    }

    //O(n^2)
    private static int LPSdp(String s,int l){
        int C[][]=new int[l][l];
        int k=0;

        //strings of length 1
        for(int i=0;i<l;i++){
            C[i][i]=1;
        }

        //iterate all substrings starting from length 2
        //Lower diagonal are useless
        for(int i=2;i<=l;i++){
            for(int j=0;j<l-i+1;j++){
                k=j+i-1;
                if(s.charAt(j) == s.charAt(k) && i==2){
                    C[j][k]=2;
                }else if(s.charAt(j) == s.charAt(k)){
                    C[j][k] = C[j+1][k-1] + 2;
                }else {
                    C[j][k] = Math.max(C[j+1][k],C[j][k-1]);
                }
            }
        }
        return C[0][l-1];
    }
}
