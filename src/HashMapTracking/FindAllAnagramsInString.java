package HashMapTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 31-05-2019
 */

/*
use sliding window to find the start points of all the anagrams pf p in string s
 */
public class FindAllAnagramsInString {

        public List<Integer> findAnagrams(String s, String p) {
            // Initializes result list.
            ArrayList<Integer> result = new ArrayList<>();

            // Checks invalid cases where we could return faster.
            if (s == null || s.length() == 0 || p.length() > s.length()) {
                return result;
            }

            // Saves 'letter -> occurrence' of String p into a HashMap.
            // When scanning through String s, by checking against this HashMap, we will know
            // whether certain character is required (or if still required) for finding p's anagram.
            HashMap<Character, Integer> requiredLetters = new HashMap<>();
            for (char c : p.toCharArray()) {
                if (requiredLetters.containsKey(c)) {
                    requiredLetters.put(c, requiredLetters.get(c) + 1);
                } else {
                    requiredLetters.put(c, 1);
                }
            }

            // Initializes a sliding window. Both 'start' and 'end' start as 0.
            // 'count' starts as the length of p, and will be used to track the number of
            // characters needed for finding an anagram of p.
            int start = 0, end = 0;
            int count = p.length();

            while (end < s.length()) {
                // ++ moves 'end' by 1 regardless of below conditions.
                char c = s.charAt(end++);
                if (requiredLetters.containsKey(c)) {
                    // If current character has value > 0 in the HashMap, it means
                    // to find p's anagram with the current 'start', this letter is still
                    // required.
                    //
                    // Then we can decrease 'count' since the current character contributes
                    // 1 character to the anagram we are looking for.
                    if (requiredLetters.get(c) > 0) {
                        count--;
                    }
                    // As long as the current character exists in HashMap, we need to update the
                    // HashMap by decreasing its occurrence by 1. This will affect next round of the loop.
                    requiredLetters.put(c, requiredLetters.get(c) - 1);
                }

                // If 'count' equals to 0, it means all characters required to construct p's anagram
                // have been found. Then current 'start' should be one of the valid results.
                if (count == 0) {
                    result.add(start);
                }

                // When the size of the sliding window equals to p's length, it means at this point we
                // need to move 'start' and 'end' together to move the sliding window until we hit the end
                // of String s. A substring can be possibly an anagram of p only if its length is p.length().
                if (end - start == p.length()) {
                    // ++ moves 'start' by 1 regardless of below conditions.
                    char startC = s.charAt(start++);
                    if (requiredLetters.containsKey(startC)) {
                        // Since we didn't find an anagram with the current 'start', while we need to move
                        // the sliding window forward due to the length requirement, we need to give up the
                        // current 'start' character, refund the credit to 'count' and move on.
                        if (requiredLetters.get(startC) >= 0) {
                            count++;
                        }

                        // Because we do 'start++' to move the sliding window, the current character should
                        // then the current character should not be taken into account any more for finding
                        // the anagram. We need to return it back to the HashMap.
                        requiredLetters.put(startC, requiredLetters.get(startC) + 1);
                    }
                }
            }
            return result;
        }
    }
