package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 15-06-2019
 */
//2 4 1 6 7  with target 7 . Find all combinations in non-decreasing order
public class CombinationSum {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int[] array = new int[]{2,4,3,6,7};
        int[] array1 = new int[]{1,2,3,4,5,6,7,8,9};
        Arrays.sort(array1);
        //combinationSum(result,new ArrayList<Integer>(), 0,0,array,7);
        combinationSumNumbers(result,new ArrayList<Integer>(), 0,0,array1,9,3);

        result.stream().forEach(list-> {
            list.stream().forEach(item-> System.out.print(item+" "));
            System.out.println();
        });

    }

    /*
    Backtracking choose/explore/unchoose
     */
    public static void combinationSum(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int start , int sum, int[] a , int T){
       if(sum>T)return;
       if(sum==T && !result.contains(list)){  //remove duplicates lists or dont recurse it
           result.add(new ArrayList<>(list));
           return;
       }

       for(int i=start;i<a.length;i++){
           list.add(a[i]);
           combinationSum(result,list,i+1,sum+a[i],a,T); //explore all others in list move the start to next,to include self dont move start
           list.remove(list.size()-1);
       }
    }

    /*
   Backtracking choose/explore/unchoose
    */
    public static void combinationSumNumbers(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int start, int sum, int[] a, int T, int k){
        if(sum>T)return;
        if(sum==T && !result.contains(list) && list.size() == k){  //remove duplicates lists or dont recurse it
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i=start;i<a.length;i++){
            list.add(a[i]);
            combinationSumNumbers(result,list,i+1,sum+a[i],a,T,k); //explore all others in list move the start to next,to include self dont move start
            list.remove(list.size()-1);
        }
    }

    private static void swap(int[] a, int i, int chosen) {
        int t= a[i];
        a[i]=a[chosen];
        a[chosen]=t;
    }
}
