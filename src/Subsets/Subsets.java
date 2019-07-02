package Subsets;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 04-06-2019
 */
public class Subsets {

    public static void main(String[] args) {
        char []set = {'1','2', '2'};
        Set<String> res = distinctSubsets(set, set.length);
        //addd an empty set
        res.forEach(str -> System.out.println(str));
    }

    private static Set<String> distinctSubsets(char[] set, int size){
        long power_set_size = (long) Math.pow(2, size);

        Set<String> result = new HashSet<>();

        /*
        from 000 to 111   (is size is 3 , total 8 elements )
         */
        for(int i=0;i<power_set_size;i++){

            String temp = "";
            for(int j = 0 ; j < size;j++){
                //check if the jth bit is set in ith number
                if( (i  & (1 << j )) > 0 ){
                    //System.out.print(set[j]);
                    temp += set[j];
                }
            }
            if(!(temp.isEmpty())){
                result.add(temp);
            }
            //System.out.println();
        }
        //System.out.println("length:"+result.size());
        return result;
    }
}
