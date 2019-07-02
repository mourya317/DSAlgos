package DFS;

/**
 * @author Mourya Balla
 * @project Practice
 * @CreatedOn 17-06-2019
 */
public class WildcardMatching {
    public static void main(String[] args) {
        //System.out.println(isMatch("xbylmzk".toCharArray(), "x?y*zk".toCharArray(),0,0));
        System.out.println(regex("g*ks","geeks"));
    }

    /*
    match with ? or * . implement DFS
     */
    private static boolean isMatch(char[] text,char[] pattern, int pos1, int pos2){
        //if both pos1,pos2 reach end that means its a match
        //return (pos2 == pattern.length && pos1 == text.length);
        if (pos2 == pattern.length) {

            return text.length == pos1;

        }

        if(pattern[pos2] != '*'){
            if(pos1 < text.length && (text[pos1] == pattern[pos2]) || pattern[pos2] == '?'){
                return isMatch(text,pattern,pos1+1,pos2+1);
            }else {
                return false;
            }
        }else {
            //if it is == * then dfs
            //handle case for multiple *
            while(pos2 < pattern.length && pattern[pos2+1] == '*'){
                pos2++;
            }
            pos1--;
            while(pos1 < text.length){
                if(isMatch(text,pattern,pos1+1,pos2+1)){
                    return true;
                }
                pos1++;
            }
            return false;
        }
    }


    /*
    Regular expression matching

    isMatch("aa","a") return false
isMatch("aa","aa") return true
isMatch("aaa","aa") return false
isMatch("aa", "a*") return true
isMatch("aa", ".*") return true
isMatch("ab", ".*") return true
isMatch("aab", "c*a*b") return true
     */

    public static boolean isMatchRegex(String s, String p){
        if(p.length() == 0){
            return s.length() == 0 ;
        }


        //handle basic case
        if(p.length() == 1 || (p.charAt(1) != '*')){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0))){
                return false;
            }
            return isMatchRegex(s.substring(1), p.substring(1));
        }

        else{
            int i=-1;
            int len = s.length();

            while(i<len && (i<0 || (p.charAt(0) == '.' || p.charAt(0) == s.charAt(i)))){
                if(isMatchRegex(s.substring(i+1) , p.substring(2))){
                    return true;
                }
                i++;
            }
            return false;
        }



    }



    public static boolean regex(String pattern , String s){
        //base case 1 : if p ,s is length 0 that mwnas we camne to the end -> matched
        if(pattern.length() == 0 && s.length() == 0 ){
            return true;
        }

        //base case 2 : if we came to the end of s and next symbol of patter is not * -> not matched
        if(s.length() == 0 && !pattern.equals('*')){
            return false;
        }

        //check the symbol match
        if(charsMatch(pattern, '?') || charsMatch(pattern,s)){
            //matched -- move to next
            return regex(pattern.substring(1),s.substring(1));
        }

        //if it is * , we can skip the wildcard or skip the next symbol
        if(charsMatch(pattern,'*')){
            return regex(pattern.substring(1),s) || regex(pattern,s.substring(1));
        }

        return false;



    }


    private static boolean charsMatch(String s, char ch) {
        return s.length() > 0 && s.charAt(0) == ch;
    }
    private static boolean charsMatch(String s, String p) {
        return s.length() > 0 && p.length() > 0 && s.charAt(0) == p.charAt(0);
    }
}
