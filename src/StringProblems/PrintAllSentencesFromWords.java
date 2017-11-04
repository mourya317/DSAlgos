package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class PrintAllSentencesFromWords {
    public static void main(String[] args) {

        String[][] words= {
                {"you", "we"},
                {"have", "are"},
                {"sleep", "eat", "drink"}

        };

        printAllSentences(words, "", 0);
    }

    private static void printAllSentences(String[][] words, String prefix, int i) {
        if(words.length==i){
            System.out.println(prefix);
            return;
        }
        String[] strs=words[i];
        i++;
        int l = strs.length;
        for(int j=0;j<l;j++){
            printAllSentences(words,prefix+" "+strs[j],i);
        }
    }
}
