package Stream;

import java.util.Random;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-05-2019
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        shuffle(a);
        for (int i : a) {
            System.out.println(i);
        }

    }

    /*

     */
    private static void swap(int[] a , int i , int change){
        int helper = a[i];
        a[i]=a[change];
        a[change]=helper;

    }

    /*
    The shuffle is random as the algorithm by selecting uniformly an element which has not been selected.
     For example if the element at position 2 is selected it can be exchanged with all elements at position 2 until position n-1 (as the list /array has 0 - n-1 positions).
     */
    private static void shuffle(int[] a ){
        int n = a.length;
        Random r = new Random();
        for(int i=0;i<n;i++){
            int change = i+r.nextInt(n-i);
            swap(a,i,change);
        }
    }


}
