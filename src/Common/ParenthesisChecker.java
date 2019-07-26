package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 24-07-2019
 */
public class ParenthesisChecker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){

            String query = br.readLine().trim();
            System.out.println(check(query)?"balanced":"not balanced");
    }


}

    private static boolean check(String query) {
        char[] chars = query.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else if(!stack.isEmpty() && ((stack.peek() == '{' && c == '}') || (stack.peek() == '(' && c == ')') || (stack.peek() == '[' && c == ']'))){
                stack.pop();
            }else{
                flag = false;
                break;
            }

        }
        if(stack.isEmpty() && flag)return true;
        return false;

    }

}
