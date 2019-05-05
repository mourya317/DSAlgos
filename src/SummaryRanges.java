
/*
Given a sorted integer array without duplicates, return the summary of its ranges for consecutive numbers.
For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

Approach: use 2 pointers , move the rt pointer until the last consecutive number , save the result .
Then move the both the pointers to next range.
 */

import java.util.ArrayList;


public class SummaryRanges {
    static int[] arr = {10, 1, 2, 3, 4, 5, 9};

    public static void main(String[] args) {
        ArrayList<String> r = summaryRanges();
        for(String s:r){
            System.out.println(s);
        }
    }

    private static ArrayList<String> summaryRanges() {
        int l = 0;
        int r = 0;
        ArrayList<String> result = new ArrayList<>();

        while (r < arr.length) {
            int temp = arr[l];
            while (r < arr.length - 1 && arr[r + 1] == temp + 1) {
                r++;
                temp++;
            }

            if(l==r)
                result.add(arr[r]+"");
            else
                result.add(arr[l] + "->" + arr[r]);

            l = r + 1;
            r++;
        }
        return result;
    }
}

