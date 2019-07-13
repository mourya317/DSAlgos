package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 10-07-2019
 */
/*
You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. A pair (c, d) can follow another pair (a, b) if b < c.
Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs.
 */
public class MaximumLengthofPairs {
    public static void main(String[] args) {
        /*Pair p0 = new Pair(5,24);
        Pair p1 = new Pair(39,60);
        Pair p2 = new Pair(15,28);
        Pair p3 = new Pair(27,40);
        Pair p4 = new Pair(50,90);
        ArrayList<Pair> list = new ArrayList<>();
        list.add(p0);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        System.out.println( pairsLength(list));*/

        System.out.println(validateDirParam("dfdfdf/"));
        System.out.println(validateDirParam("/dfdfdf"));
        System.out.println(validateDirParam("//dfds33454xcFFGFGGfdf/"));
    }

    private static class Pair {
        int f;
        int s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }


    //variation if LIS
    private static int pairsLength(ArrayList<Pair> pairs) {
        //sort based on the first element in the pair
        Collections.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.f>o2.f)return 1;
                else if(o1.f==o2.f)return 0;
                else return -1;
            }
        });

        //build LIS
        int n = pairs.size();
        int[] LIS = new int[n];
        Arrays.fill(LIS,1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs.get(i).f > pairs.get(j).s && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,LIS[i]);
        }
        return max;
    }



    private static boolean validateDirParam(String dirParam){
       // return dirParam.matches("\\/\\w+\\/");
        return (dirParam.startsWith("/") && dirParam.endsWith("/"));
    }


}
