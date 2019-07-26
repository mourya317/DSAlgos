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
/*
You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.
https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/?track=md-stack&batchId=144
he first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow. First line of each test case contains an integer Q denoting the number of queries.
A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.

Output:
The output for each test case will  be space separated integers having -1 if the stack is empty else the element poped out  or min element from the stack.


User Task:
You are required to complete the three methods push() which take one argument an integer 'x' to be pushed into the stack, pop() which returns a integer poped out from the stack and getMin() which returns the min element from the stack.

Constraints:
1 <= T <= 100
1 <= Q <= 100
1 <= x <= 100

Example:
Input:
1
6
1 2 1 3 2 3 1 1 3

Output:
3 2 1

Explanation:
Testcase 1:
In the first test case for query
1 2  the stack will be {2}
1 3  the stack will be {2 3}
2 poped element will be 3 the stack will be {2}
3 min element will be 2
1 1 the stack will be {2 1}
3 min element will be 1 and
 */
public class MinFromStack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){

            int queries = Integer.parseInt(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            int size = inputLine.length-1;

            MinOptimizedStack stack = new MinOptimizedStack();
            int current =0 ;

            for(int i=1;i<=queries;i++){
                int type = Integer.parseInt(inputLine[current++]);
                if(type == 1 ){
                    stack.push(Integer.parseInt(inputLine[current++]));
                }else if(type == 2 ){
                    System.out.print(stack.pop()+" ");
                }else if(type == 3 ){
                    System.out.print(stack.getMin()+" ");
                }
            }


        }
    }

    static class MinOptimizedStack{
        Stack<Integer> stack = new Stack<>();

        int min = Integer.MAX_VALUE;

        public void push(int element){
            stack.push(element);
            if(stack.size() == 1){
                min = element;
            }else{

                min = Math.min(min,element);
            }
        }

        public int pop(){
            //We need to find the new min value if current min is getting popped out
            if(stack.isEmpty())return -1;
            if(stack.peek() != min)return stack.pop();

            min = Integer.MAX_VALUE;
            int x = stack.pop();
            Stack<Integer> temp = new Stack<>();
            while(!stack.isEmpty()){
                int y = stack.pop();
                min = Math.min(min,y);
                temp.push(y);
            }


            //Refill stack
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }

            return x;
        }

        public int getMin(){
            if(stack.isEmpty())return -1;
            return min;
        }

    }


}
