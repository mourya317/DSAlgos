package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class ReverseWordsString {

    public static void main(String[] args){
        String s = rev("Hello world robot");
        System.out.print(s);
    }

    private static String rev(String S){
        String[] splits = S.split(" ");
        String newStr= "";
        for(String str: splits) {
            newStr= str+" "+newStr;
        }
        return newStr;
    }
}
