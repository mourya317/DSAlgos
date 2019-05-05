import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] in = {1,6,8,4,9,6,7};
        int[] out = removeElement(in,6);
        for(int e:out) {
            System.out.println(e);
        }
    }

    private static int[] removeElement(int[] in, int e){
        //using 2 pointers to traverse the array
        int i=0;
        int j=in.length-1;
        while(i<=j){
            if(in[i] == e){
                //overwrite last with the element
                if(in[j]==e){
                    j--;
                    continue;
                }else{
                    in[i]=in[j];
                    j--;
                }
            }
            i++;
        }
        System.out.println("j:"+j);
        int[] out= Arrays.copyOf(in,j+1);
        return out;
    }
}
