package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class PrintAllPossibleStringOfLenK {
    public static void main(String[] args) {
        String s = "ab";
        printLenK(s.toCharArray(),"",3);
    }

    private static void printLenK(char[] set,String prefix,int k){
            if(k==0){
                System.out.println(prefix);
                return;
            }
        //add to prefix one by one and call recursively
        for(int i=0;i<set.length;i++){
           printLenK(set,prefix+set[i],k-1);
        }
    }
}
