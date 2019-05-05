import java.util.ArrayList;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 23-02-2019
 */
public class ReverseVowelsOfString {

    static List<Character> vowels = new ArrayList<>();

    public static void main(String[] args) {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        System.out.println(reverseVowels("aeroplane"));
    }

    /*
    2 pointers from front and back and swap the vowels
     */
    private static String reverseVowels(String s){
        char[] str = s.toCharArray();
        int f = 0;
        int b = s.length()-1;
        int i = 0;

        while(f<b){

            if(!vowels.contains(s.charAt(f))){
                f++;
                continue;
            }
            if(!vowels.contains(s.charAt(b))){
                b--;
                continue;
            }

            //swap
            //str = swap(str,f,b);
            char temp ;
            temp = str[f];
            str[f]=str[b];
            str[b]=temp;

            f++;
            b--;
        }
        return new String(str);
    }

    private static char[] swap(char[] str, int f, int b) {
        char temp ;
        temp = str[f];
        str[f]=str[b];
        str[b]=temp;
        return str;
    }
}
