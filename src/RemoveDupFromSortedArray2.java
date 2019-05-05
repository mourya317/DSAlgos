import java.util.Arrays;

public class RemoveDupFromSortedArray2 {
    public static void main(String[] args) {

        int[] A = {1,1,2,3,3,3};
        int[] B = solution(A);
        for(int x:B) {
            System.out.println(x);
        }
        System.out.println("length:"+B.length);
    }

    public static int[] solution(int[] in){
        if(in.length < 2) return in;
        int prev = 1;
        int curr=2;
        while(curr < in.length){
            if(in[prev] == in[curr] && in[prev-1] == in[curr]){
                curr++;
            }else{
                prev++;
                in[prev] = in[curr];
                curr++;
            }
        }

        int[] out = Arrays.copyOf(in,prev+1);
        return out;
    }
}
