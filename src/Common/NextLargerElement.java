package Common;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 23-07-2019
 */
public class NextLargerElement {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        while(N-- > 0 ){
            int M = sc.nextInt();
            long[] arr = new long[M];
            for(int i=0;i<M;i++){
                arr[i] = sc.nextLong();
            }

            solution(arr);
            //Arrays.stream(ans).forEach(r -> System.out.print(r+" "));

        }
    }

    private static void solve(long[] arr) {
        long[] result = new long[arr.length];
        result[arr.length - 1] = -1l;
        //Use 2 queues .
        Stack<Long> stack = new Stack<>();
        stack.push(arr[arr.length - 1]);

        for (int i = arr.length - 2; i >= 0; i--) {
            Long e = arr[i];
            while (stack.peek() < e) {

                stack.pop();
                if (stack.isEmpty()) break;
            }


            if (stack.isEmpty()) result[i] = -1l;
            else result[i] = stack.peek();

            stack.push(e);

        }
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        //return result;
    }


    /*
    GOOD
     */
    private static void solution(long[] arr){
        Stack<Long> stack = new Stack<>();
        //push first element to stack
        stack.push(arr[0]);

        for(int i=1;i<arr.length;i++){
            long next = arr[i];

            while(!stack.isEmpty() && stack.peek() < next){
                System.out.print(next+" ");
                stack.pop();
            }
            stack.push(next);
        }

        //print -1
        while(!stack.isEmpty()){
            stack.pop();
            System.out.print("-1"+" ");
        }

    }



}
