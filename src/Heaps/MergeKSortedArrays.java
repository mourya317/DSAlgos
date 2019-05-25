package Heaps;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 13-05-2019
 */

/*
Naive Solution: O(nkLognk)
Create an result[] of size n*k.
Copy all the elements from k arrays into result array. This will take O(nk).
Sort the result[] using Merge Sort. This will take O(nkLognk) time.


Better solution nklogk

1. Create a result[] of size n*k
2. create a heapNode which has data and from which list it comes from
3. take the first element from each k lists and put in minheap
4. remove the root and insert into result , get the source list of the removed element
5. insert next lement from that src list
6. repeat it

 */
public class MergeKSortedArrays {

    static PriorityQueue<HeapNode> queue = new PriorityQueue<>();


    public static List<Integer> merge(int[][] arr , int k) {

        List<Integer> result = new ArrayList<>();
        int[] index = new int[k];
        //insert the first elements into queue
        for (int i = 0; i < k; i++) {
            queue.add(new HeapNode(arr[i][0], i));
            index[i] = 0;
        }

        while (queue.size() != 0) {
            //poll first minimum
            HeapNode e = queue.poll();
            int lastId = e.listId;
            result.add(e.data);

            //extract next element from lastId and update the index as well
            try {
                int nextElement = arr[lastId][++index[lastId]];
                queue.add(new HeapNode(nextElement, lastId));
                //index[lastId] += 1;
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("index out of bounds.." + ex.getMessage());
            }

        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {9,10,45},
                {6,11,46,65,90}
        };

        List<Integer> result = merge(arr ,3);
        for(int u:result){
            System.out.println(u);
        }
    }

}


class HeapNode implements Comparable<HeapNode>{
    int data;
    int listId;

    HeapNode(int data, int listIndex) {
        this.data = data;
        this.listId = listIndex;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(HeapNode o) {
        return data - o.data;
    }
}