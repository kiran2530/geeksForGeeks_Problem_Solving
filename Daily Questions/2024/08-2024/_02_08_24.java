/*
 *  Q) Edit Distance
        Given two strings str1 and str2. Return the minimum number of operations required to convert str1 to str2.
        The possible operations are permitted:

        Insert a character at any position of the string.
        Remove any character from the string.
        Replace any character from the string with any other character.
    
    Examples:1
        Input: str1 = "geek", srt2 = "gesek"
        Output: 1
        Explanation: One operation is required, inserting 's' between two 'e'.
    
    Examples:1
        Input : str1 = "gfg", str2 = "gfg"
        Output: 0
        Explanation: Both strings are same.
        Expected Time Complexity: O(|str1|*|str2|)
        Expected Space Complexity: O(|str1|*|str2|)

    Constraints:
        1 ≤ str1.length(), str2.length() ≤ 100
        Both the strings are in lowercase.
 */
public class _02_08_24 {
    public static int editDistance(String str1, String str2){
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) dp[i][0] = i;
        
        for(int j = 0; j <= n; j++) dp[0][j] = j;

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i-1][j-1]);
                }
            }
        }
            return dp[m][n];
    }
    public static void main(String[] args) {
        String str1 = "geek", str2 = "gesek";
        System.out.println(editDistance(str1, str2));
    }
}
