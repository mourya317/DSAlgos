import java.util.Arrays;
import java.util.Scanner;

public class RemoveDupFromSortedArray {
    public static void main(String[] args) {

        int[] A = {1,1,2,2,3,4,5,5,5};
        int[] B = solution(A);
        for(int x:B) {
            System.out.println(x);
        }
        System.out.println("length:"+B.length);
    }

    public static int[] solution(int[] in){
        int prev = 0;
        int curr=1;
        while(curr < in.length){
            if(in[prev] == in[curr]){
                curr++;
            }else{
                prev++;
                in[prev]=in[curr];
                curr++;
            }
        }

        int[] out = Arrays.copyOf(in,prev+1);
        return out;
    }
}
