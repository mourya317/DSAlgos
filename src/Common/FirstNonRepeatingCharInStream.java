package Common;

import com.sun.deploy.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-07-2019
 */
public class FirstNonRepeatingCharInStream {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){

            int N = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
           String in = convertArrayToStringUsingStreamAPI(inputLine);


           findNonrep(in);
            //System.out.println(check(query)?"balanced":"not balanced");
        }
    }

    public static String convertArrayToStringUsingStreamAPI(String[] strArray) {
        String joinedString = String.join("", strArray);
        return joinedString;
    }

    /*
    Have a Double linked list of nodes , maintain an array of repeated items of size 256
     */
    private static void findNonrep(String in) {
        List<Character> inDLL = new LinkedList<>();
        Boolean[] repeated = new Boolean[256];
        Arrays.fill(repeated,false);

        for(int i=0;i<in.length();i++){
            //we need to process this char only if not repeated
            char c = in.charAt(i);
            if(!repeated[c]){
                if(!(inDLL.contains(c))){
                    inDLL.add(c);
                }else{
                    //if contains mark as repeated and remove from the Q
                    inDLL.remove((Character)c);
                    repeated[c] = true;
                }
            }

            //print the output
            if(inDLL.size() !=0){
                System.out.print(inDLL.get(0)+" ");
            }else{
                System.out.print("-1 ");
            }
        }

    }
}
