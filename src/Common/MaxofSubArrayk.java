package Common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-07-2019
 */
public class MaxofSubArrayk {
    public static void main(String[] args) throws IOException {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0 ){

            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                arr[i] = sc.nextInt();
            }
            maxsubk(arr, N, K);
        }
    }

    private static void maxsubk(int[] a , int n, int k ){

        //use nextlargerElleemnt code to build max_upto[i] i.e if we know if a[i] is max upto wic location we can move the sliding window of size k
        int[] max_upto = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1;i<n;i++){
            while(!s.isEmpty() && a[s.peek()] < a[i]){
                max_upto[s.peek()] = i-1; //it is max upto i-1
                s.pop();
            }
            s.push(i);
        }

        while (!s.isEmpty()){
            max_upto[s.peek()] = n-1; //all remainaing ele are max upto the last
            s.pop();
        }


        //Move the sliding window
        int j = 0 ;
        for(int i=0;i<= n-k;i++){
            while(j < i || max_upto[j] < i + k -1){
                j++;
            }
            System.out.print(a[j]+" ");
        }
        System.out.println();
    }
}
