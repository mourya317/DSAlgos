package Subsets;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 04-06-2019
 */
/*
Generate All possible subsequences
 */

public class PowerSet {

    public static void main(String[] args) {
        char []set = {'a', 'b', 'c'};
        powerset(set, 3);
    }

    /*
    Total number of poerset is   If S has n elements in it then P(s) will have 2^n element (including empty set)

    Power set P(S) of a set S is the set of all subsets of S. For example S = {a, b, c} then P(s) = {{}, {a}, {b}, {c}, {a,b}, {a, c}, {b, c}, {a, b, c}}.


    System.out.println(10<<2);//10*2^2=10*4=40
System.out.println(10<<3);//10*2^3=10*8=80
System.out.println(20<<2);//20*2^2=20*4=80
System.out.println(15<<4);//15*2^4=15*16=240

     */
    private static void powerset(char[] set, int size){
        long power_set_size = (long) Math.pow(2, size);

        int c =0 ;


        /*
        from 000 to 111   (is size is 3 , toptal 8 elements )
         */
        for(int i=0;i<power_set_size;i++){

            for(int j = 0 ; j < size;j++){
                //check if the jth bit is set in ith number
                if( (i  & (1 << j )) > 0 ){
                    System.out.print(set[j]);
                }
            }
            System.out.println();
        }
    }
}
