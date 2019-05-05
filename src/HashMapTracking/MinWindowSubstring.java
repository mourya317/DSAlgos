package HashMapTracking;

import java.util.HashMap;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 02-05-2019
 */
public class MinWindowSubstring {
    public static void main(String[] args) {
        System.out.println(minWinSubstring("QWAHBOICEBCDA","ABC"));
    }


    public static String minWinSubstring(String s, String t){
        HashMap<Character, Integer> goal = new HashMap<>();
        int goalSize = t.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";
        //target dictionary
        for(int i=0;i<t.length();i++){
            goal.put(t.charAt(i),goal.getOrDefault(t.charAt(i),0)+1);
        }


        int start =0;int total=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);

            if(!goal.containsKey(s.charAt(j))){
                continue;
            }

            int count = map.getOrDefault(c,0);
            if(count<goal.get(c)){
                total++;
            }

            map.put(c,count+1);

            if(total==goalSize){
                while(!goal.containsKey(s.charAt(start)) || map.get(s.charAt(start)) > goal.get(s.charAt(start))){
                    char pc = s.charAt(start);
                    if(goal.containsKey(pc) && map.get(pc)>goal.get(pc)){
                        map.put(pc, map.get(pc)-1); // decrease count
                    }
                    start++;
                }

                if(minLen > j-start+1){
                    minLen = j-start+1;
                    result = s.substring(start,j+1);
                }
            }
        }
        return result;
    }
}
