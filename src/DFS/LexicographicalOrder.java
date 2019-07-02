package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 01-07-2019
 */
/*
For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 */
public class LexicographicalOrder {
    public static void main(String[] args) {
        List<Integer> list = lexicalOrder(13);
        list.stream().forEach(s-> System.out.println(s));
    }


    private static List<Integer> lexicalOrder(int n){
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(String.valueOf(i));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int i=0;
                while(i<a.length() && i<b.length()){
                    if(a.charAt(i) != b.charAt(i)){
                        return a.charAt(i) - b.charAt(i);
                    }
                    i++;
                }

                if(i>=a.length()){
                    return -1;
                }
                return 1;

            }
        });

        List<Integer> result = new ArrayList<>();
        for(String s: list){
            result.add(Integer.parseInt(s));
        }

        return result;
    }
}
