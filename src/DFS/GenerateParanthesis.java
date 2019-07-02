package DFS;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 13-06-2019
 */

// if n = 3 ; "((()))", "(()())", "(())()", "()(())", "()()()"
public class GenerateParanthesis {
    public static LinkedHashSet<String> result = new LinkedHashSet<>();
    public static void main(String[] args) {
        /*ArrayList<String> res = new ArrayList<>();
        dfs(res,"",3,3);
        res.forEach(s -> System.out.println(s));*/


        backtrackingPermute("((()))","",3,3);
        result.forEach(s-> System.out.println(s));
        /*List<String> list = new ArrayList<>();
        list.addAll(result);*/
    }

    private static void dfs(ArrayList<String> result, String s , int left, int right){
        if(left>right)return;

        if(left == 0 && right == 0 ){
            result.add(s);
            return;
        }

        if(left>0){
            dfs(result, s+"(",left-1,right);
        }

        if(right>0){
            dfs(result, s+")",left,right-1);
        }
    }


    //Backtracking algo
    private static void backtrackingPermute(String s,String chosen,int left , int right){
        if(left>right)return;
        if(left == 0 && right==0){
           // System.out.println(chosen);
            result.add(chosen);
            return;
        }

        //choose/explore/unchoose
        for(int i=0;i<s.length();i++){
            boolean isLeft = s.charAt(i) == "(".toCharArray()[0];
            chosen += s.charAt(i);
            StringBuilder sb= new StringBuilder(s);
            sb.deleteCharAt(i);
            if(isLeft){
                backtrackingPermute(sb.toString(),chosen,left-1,right);
            }else {
                backtrackingPermute(sb.toString(),chosen,left,right-1);
            }
            chosen = chosen.substring(0,chosen.length()-1);
        }
    }


}
