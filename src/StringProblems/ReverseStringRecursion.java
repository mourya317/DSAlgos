package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class ReverseStringRecursion {
    private static String S = "MOURYA";
    public static void main(String[] args){
        String s = rev(S,0);
        System.out.print(s);
    }
    private static String rev(String S,int i){
        if(S.length() == i)return "";
        return (rev(S,i+1)+S.charAt(i));
    }
}
