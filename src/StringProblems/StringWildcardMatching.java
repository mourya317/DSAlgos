package StringProblems;

/**
 * Created by mballa on 04.11.2017.
 */
public class StringWildcardMatching {
    public static void main(String[] args){
        System.out.print(isStringMatched("mourya","m**r?a*"));
    }

        private static boolean isStringMatched(String text, String pat) {
            int l= text.length();
            int n= pat.length();
            int starIndex= -1;
            int iIndex= -1;
            int i= 0;
            int j= 0;
            while(i<l) {
                if(j<n && ((text.charAt(i)== pat.charAt(j)) || (pat.charAt(j)== '?'))) {
                    j++;
                    i++;
                } else if(j<n && pat.charAt(j)== '*') {
                    starIndex= j;
                    iIndex= i;
                    j++;
                } else if(starIndex!= -1) {
                    j= starIndex+1;
                    i= iIndex+1;
                    iIndex++;
                } else {
                    return false;
                }
            }

            while(j<n && pat.charAt(j)== '*') {
                j++;
            }

            if(j!= n) {
                return false;
            }
            return true;
        }
    }

