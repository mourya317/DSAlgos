package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class PermutationsOfString {
    public static void main(String[] args){
        permute("","abc");
        //permuteBacktracking("abc",0,2);
    }

    private static void permute(String prefix,String str) {
        int l=str.length();
        if(l == 0 ){
            System.out.println(prefix);
        }
        for(int i=0;i<l;i++){
            permute(prefix+str.charAt(i),str.substring(0,i)+str.substring(i+1));
        }
    }

    private static void permuteBacktracking(String s,int l,int r){
        if(l == r){
            System.out.println(s);
        }
        else{
            for(int i=l;i<=r;i++){
                s=swap(s,l,i);
                permuteBacktracking(s,l+1,r);
                s=swap(s,l,i);
            }
        }
    }

    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
