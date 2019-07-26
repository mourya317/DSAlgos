package Common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-07-2019
 */
public class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
     return 0;
    }

    /* The method push to push element into the stack */
    void push(int a)
    {
        //push into empty Q and populate all elelments of other stack into it
        if(q1.isEmpty()){
            q1.poll();
        }
    }
}
