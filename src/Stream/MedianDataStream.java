package Stream;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 14-05-2019
 */
public class MedianDataStream {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.add(5);
        medianFinder.add(15);
        medianFinder.add(1);
        medianFinder.add(3);
        /*medianFinder.add(94);
        medianFinder.add(6);
        medianFinder.add(69);
        medianFinder.add(6);*/
        //medianFinder.add(90);

        int i=0;
       /* while(true){
            if(i%100 == 0){
                System.out.println("Min heap size::"+medianFinder.minHeap.size());
                System.out.println("Max heap size::"+medianFinder.maxHeap.size());
            }
            medianFinder.add(i++);
        }*/

        System.out.println(medianFinder.findMedian());
    }

    static class MedianFinder{
        PriorityQueue<Integer> minHeap = null;
        PriorityQueue<Integer> maxHeap = null;

        public MedianFinder(){
            this.minHeap = new PriorityQueue<Integer>();
            this.maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        }

        /*
        1.When we add a number we first add to min heap
        2. poll minheap and add to max heap (ensure all elements of min heap are > max heap)
        3. load balance both
         */
        public void add(int num){
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());

            //Load balance
            if(maxHeap.size() > minHeap.size()){
                minHeap.offer(maxHeap.poll());
            }
        }

        public double findMedian(){
            //if odd
            if(minHeap.size() > maxHeap.size()){
                return minHeap.peek();
            }else {
                return( minHeap.peek()+maxHeap.peek())/2.0;
            }
        }
    }
}
