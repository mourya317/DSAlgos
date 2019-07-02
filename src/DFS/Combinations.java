package DFS;

import java.util.ArrayList;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 01-07-2019
 */

/*
Given n=4 and k=2, get all combinations of of k numbers out of 1...n ..(DFS)
 */
public class Combinations {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        combinations(result, new ArrayList<Integer>(), 1,2, 4);
        result.stream().forEach(list-> {
            list.stream().forEach(item-> System.out.print(item+" "));
            System.out.println();
        });
    }



    /*
    Backtracking algorithm O(n!)
     */
    private static void combinations(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list , int start ,int k, int n){
        //base case
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<=n;i++){
            //choose / explore / unexplore
            list.add(i);
            combinations(result, list,i+1, k,n);
            list.remove(list.size()-1);
        }

    }
}
