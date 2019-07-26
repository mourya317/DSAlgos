package Common;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-07-2019
 */
public class MaxofSubArrayk_maxheap {
    public static void main(String[] args)throws IOException
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-- > 0)
        {
            PriorityQueue<Long> Q = new PriorityQueue<Long>(new Comparator<Long>() {
                @Override
                public int compare(Long o1, Long o2) {
                    if(o1.equals(o2))
                        return 0;
                    else if(o1 < o2)
                        return 1;
                    else
                        return -1;
                }
            });
            int n = s.nextInt();
            int k = s.nextInt();
            long []arr = new long[n];
            for(int i = 0 ; i < n ; i++)
                arr[i] = s.nextLong();
            for(int i = 0 ; i < n-k+1 ; i++)
            {
                for(int j = i ; j < i+k ; j ++)
                    Q.add(arr[j]);
                System.out.print(Q.peek()+" ");
                Q.clear();
            }
            System.out.println();
        }
        s.close();
    }
}
