package StringPatternMatching;

/**
 * Created by mballa on 03.11.2017.
 * naive implementation O((S-P)*P)
 */
public class patternMatching {

    public static void main(String[] args){
        String S = "MOURYA";
        String P = "OURYA";
        match(S,P);
    }


    private static void match(String S,String P){
        int sLen = S.length();
        int pLen = P.length();
        for(int i=0;i<=sLen-pLen;i++){
            if(findMatch(S,i,P,0)){
                System.out.println("match found at:"+i);
            }
        }

    }

    private static boolean findMatch(String S,int i,String P,int j){
        int l=0;
        for(int k=i;k<i+(P.length());k++){
            if(S.charAt(k) != P.charAt(l)){
                return false;
            }
            l++;
        }
        return true;
    }
}
