package Common;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 26-07-2019
 */
public class LRUCache {
    static Deque<Integer> dq;
    static HashSet<Integer> set;
    static int capacity;

    LRUCache(int N){
        this.capacity=N;
        dq=new LinkedList<>();
        set=new HashSet<>();
    }


    public void refer(int x){
        if(!set.contains(x)){
            if(dq.size() == capacity){
                //remove last
                int last = dq.removeLast();
                set.remove(last);
            }
        }else{
            //access the element and move it to the start of deque
            int index = 0; int i=0;
            Iterator<Integer> itr = dq.iterator();
            while(itr.hasNext()){
                if(itr.next() == x ){
                    index = i;
                    break;
                }
                i++;
            }
            dq.remove(index);
        }
        dq.push(x);
        set.add(x);
    }


    // display contents of cache
    public void display()
    {
        Iterator<Integer> itr = dq.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
    }

    public static void main(String[] args)
    {
        LRUCache ca = new LRUCache(4);
        ca.refer(1);
        ca.refer(2);
        ca.refer(3);
        ca.refer(1);
        ca.refer(4);
        ca.refer(5);
        ca.display();
    }
}
