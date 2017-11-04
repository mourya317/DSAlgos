package StringPatternMatching;

/**
 * Created by mballa on 03.11.2017.
 */
public class KMP {

    public static void main(String[] args){

    }

    private static void KMPSearch(String pat , String txt){
        int M=pat.length();
        int N=txt.length();

        int[] lps= computeLpsArray(pat,M);
        int j=0;  //index for pat[]
        int i=0;  //index for txt[]

        while(i<N){
            if(txt.charAt(i) == pat.charAt(j)){
                j++;
                i++;
            }
            if(j==M){
                System.out.println("match found at :"+(i-j));
                j=lps[j-1];
            }
            //mismatch after j matches
            else if(i<N && pat.charAt(j) != txt.charAt(i)){
                //do not match lps[0...lps[j-1]] characters ,they match anyways
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
    }

    private static int[] computeLpsArray(String P,int M){
        int[] lps= new int[M];
        lps[0]=0;
        int i = 1; //start from 1 since lps[0] is always 0
        int len = 0 ;
        while(i < M){
            if(P.charAt(i) == P.charAt(len)){ //if matched move
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){  // len is len upto previous index
                    len=lps[len-1];
                }else{ //is len =0 , lps[i]=0 ; not matched upto now.
                    lps[i]=len;
                    i++;
                }
            }
        }
        return lps;

    }
}
