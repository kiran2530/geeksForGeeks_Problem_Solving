public class Longest_palindrome {
    public static boolean isPalindrome(String s, int i, int j) {
        while (i<=j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    public static String longestPalin (String S){
        String ans = "" + S.charAt(0);
        for(int i=0; i<S.length(); i++) {
            for(int j=i+1; j<S.length(); j++) {
                if(S.charAt(i) == S.charAt(j) && (j-i+1) > ans.length() && isPalindrome(S,i,j)) {
                    ans = S.substring(i,(j-i+1));
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String S = "rfkqyuqufjkxy";
        System.out.println(longestPalin(S));
    }
}
