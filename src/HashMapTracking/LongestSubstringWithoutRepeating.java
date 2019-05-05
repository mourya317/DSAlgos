package HashMapTracking;

import java.util.*;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 25-04-2019
 */
public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        //System.out.println(lognestSubstring("abcabcbb"));
        System.out.println(longestSubstringWithAtmostKDistinctValues("abcbbbbcccbdddadacb", 2));
    }

    private static int lognestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new LinkedHashSet<>();
        int i = 0;
        int result = 1;

        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                result = Math.max(result, set.size());
            } else {
                //slid the window , remove the elements from set
                while (i < j) {
                    if (s.charAt(j) == c) {
                        i++;
                        break;
                    }

                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }
        for (Character c : set) {
            System.out.print(c);
        }
        System.out.println();
        return result;
    }

    private static int longestSubstringWithAtmostKDistinctValues(String s, int k) {

        HashMap<Character, Integer> map = new LinkedHashMap<>();
        int result = 0;
        int i = 0;

        int start=0;
        int end =0;
        //Track all the characters and its count
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt((j));
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }


            if (map.size() <= k) {
                if(result < (j-i+1)){
                    result = j-i+1;
                    end=j;
                    start=i;
                }

            } else {
                while (map.size() > k) {
                    //we need to remove the elements until map.size <= k
                    int count = map.get(s.charAt(i));
                    if (count == 1) {
                        map.remove(s.charAt(i));
                    } else {
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    }
                    i++;
                }
            }
           // System.out.println();
        }
        //for(int u=start;u<=end;u++){

            //System.out.print(s.charAt(start));
            System.out.println(s.substring(start,end+1));
        //}
        return result;
    }
}
