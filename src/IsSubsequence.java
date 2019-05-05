public class IsSubsequence {
    static String t = "acekckkkfdjt";
    static String s = "ace";
    public static void main(String[] args) {
        System.out.println(isSubsequence(t,s));
        System.out.println(isSubs(t,s));
    }

    private static boolean isSubsequence(String t, String s) {
        //check if s is subsequence of t
        // Traverse t and check the existance of each char of s
        int tLength = t.length();
        int j = 0;
        int matchCount =0 ;
        for(int i=0;i<s.length();i++){
            Character c = s.charAt(i);
            //find the c in t
            while(j < tLength){
                if(t.charAt(j) == c){
                    matchCount++;
                    j++;
                    break;
                }
                j++;
            }
        }
        return matchCount == s.length();
    }

    private static  boolean isSubs(String t, String s){
        if(s.length() == 0 )return true;
        int i =0;
        int j=0;
        while(i<s.length() && j< t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
            if(i == s.length()){
                return true;
            }
        }
        return false;
    }
}
