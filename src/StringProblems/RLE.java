package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class RLE {
    public static void main(String[] args) {
        String s= "wwwwwaaadexxxxxg";
        String runLengthEncoding = runLengthEncoding(s);
        System.out.println(runLengthEncoding);
    }

    private static String runLengthEncoding(String s) {
        int l = s.length();
        int count = 1;
        Character c = s.charAt(0);
        String str ="";
        for(int i=1;i<l;i++){
            if(c==s.charAt(i)){
                count++;
            }else{
                str=str+c+count;
                count=1;
                c=s.charAt(i);
            }
            if(i==l-1){
                str=str+c+count;
            }
        }
        return str;
    }

}
