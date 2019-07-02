package Subsets;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 04-06-2019
 */
/*
number if permutations is n!
 */
public class Permutations {
    public static void main(String[] args) {
        String s = "123";
        //permutationIntArray(new int[]{1,2,3},3);
        //permuteString("123");
        /*Set<String> set = permute(s);

        set.forEach(st -> System.out.println(st));*/

       // permutationsWithChangingCase("abc");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
        System.out.println(OffsetDateTime.now( ZoneOffset.UTC ).format(formatter));

    }

    private static void permuteString(String s){
        permuteHelper(s,"");//start with ""
    }

    private static void permuteHelper(String s, String chosen) {
        if(s.isEmpty()){
            System.out.println(chosen);
            return;
        }
        //choose/explore/unchoose
        for(int i=0;i<s.length();i++) {
            chosen += s.charAt(i);
            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);

            permuteHelper(sb.toString(),chosen);
            chosen = chosen.substring(0,chosen.length()-1);
        }
    }


    /*
    Backtracking implementation
     */
    private static void permutationIntArray(int[] a, int n){
        helper(a,n,0);
    }


    private static void helper(int[] a, int n, int i){
        //we need to fill the positions one by one - not additional array
        // To fill a position we need to know the choices

        if(i==n){
            printArr(a,n);
            return;
        }
        for(int x=i;x<n;x++){
            swap(a,x,i); //Fill 0th position and mark as Done
            helper(a,n,i+1);
            swap(a,x,i); //Backtracking


        }
        //Follow each choice and move fwd
        //When we run out of choices we print and we backtrack
    }

    private static void printArr(int[] a, int n) {
        for(int j:a) {
            System.out.print(j);
        }
        System.out.println();
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }

    private static Set<String> permute(String str){
        if(str.length() == 0 ){
            Set<String> res = new HashSet<>();
            res.add("");
            return res;
        }

        char ch = str.charAt(0);
        String restStr = str.substring(1);

        //recurse reset of the string
        Set<String> prevRes = permute(restStr);

        Set<String> res = new HashSet<>();
        for(String s : prevRes){
            for(int i=0;i<=s.length();i++){
                String f = s.substring(0,i)+ch+s.substring(i);
                res.add(f);
            }
        }
        return res;
    }


    // Function to generate permutations
    static void permutationsWithChangingCase(String input)
    {
        int n = input.length();

        // Number of permutations is 2^n
        int max = 1 << n;

        // Converting string to lower case
        input = input.toLowerCase();

        // Using all subsequences and permuting them
        for(int i = 0;i < max; i++)
        {
            char combination[] = input.toCharArray();

            // If j-th bit is set, we convert it to upper case
            for(int j = 0; j < n; j++)
            {
                if(((1 << j) &  i) > 0 ) // OR (i >> j ) & 1 == 1
                    combination[j] = (char) (combination[j]-32);
            }

            // Printing current combination
            System.out.print(combination);
            System.out.print("   ");
        }
    }

}
