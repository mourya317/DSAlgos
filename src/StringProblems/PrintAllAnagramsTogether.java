package StringProblems;

import java.util.*;

/**
 * Created by mballa on 04.11.2017.
 */
public class PrintAllAnagramsTogether {
    public static void main(String[] args){
        String[] strs= {"cat", "dog", "tac", "god", "act"};
        print(strs);
    }

    private static void print(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String sortedS = sort(s);
            System.out.println("s:"+sortedS);
            if(map.containsKey(sortedS) ){
                List l = map.get(sortedS);
                l.add(s);
                map.put(sortedS,l);
            }else{
                List<String> list= new ArrayList<>();
                list.add(s);
                map.put(sortedS,list);
            }
        }
        System.out.print(map);
        //print map
        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            List<String> l = entry.getValue();
            for(String s:l){
                System.out.println(s);
            }
        }
    }

    private static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
