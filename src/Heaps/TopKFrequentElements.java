package Heaps;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 05-05-2019
 */
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {4,4,4,9,9,0,0,0,0,8,3};
        List<Integer> res = topKFreqItems(arr, 4);
        for(int i:res){
            System.out.println(i);
        }
    }

    /*
    Use max heap store the map.entry elements based on their frequency
     */
    private static List<Integer> topKFreqItems(int[] items , int k){

        // 1. count the frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i:items){
            freq.put(i , freq.getOrDefault(i,0)+1);
        }

        // 2. create a max heap
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> m: freq.entrySet()){
            queue.offer(m);
            if(queue.size() > k ){
                queue.poll(); //we need to maintain a heap of size k , unnecessary minimums can be dropped after reaching k elements
            }
        }

        //print
        List<Integer> result = new ArrayList<>();
        while(queue.size() > 0){
            result.add(queue.poll().getKey());
        }

          Collections.reverse(result);
        return result;

    }
}
