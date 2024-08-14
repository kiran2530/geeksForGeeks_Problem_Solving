/*
 *  Q) Longest Common Substring
        You are given two strings str1 and str2. Your task is to find the length of the longest common substring among the given strings.

    Example : 1
        Input: str1 = "ABCDGH", str2 = "ACDGHR"
        Output: 4
        Explanation: The longest common substring is "CDGH" which has length 4.
        
    Example : 2
        Input: str1 = "ABC", str2 = "ACB"
        Output: 1
        Explanation: The longest common substrings are "A", "B", "C" all having length 1.
        
    Expected Time Complexity: O(n*m).
    Expected Auxiliary Space: O(n*m).

    Constraints:
        1<= str1.size(), str2.size()<=1000
        Both strings may contain upper and lower case alphabets.
 */
public class _14_08_24 {
    public static int help(String s1, String s2) {
        int i=0, j=0, length =0;

        while (i!=s1.length() && j!=s2.length()) {
            if(s1.charAt(i) == s2.charAt(j))
                length++;
            else 
                break;
            i++;
            j++;
        }
        return length;
    }
    public static int longestCommonSubstr(String str1, String str2) {
        int result = 0;

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int temp = help(str1.substring(i), str2.substring(j));

                if(result < temp)
                    result = temp;
            }
        }

        return result;
    }    
    public static void main(String[] args) {
        String str1 = "ABCDGH", str2 = "ACDGHR";
        System.out.println(longestCommonSubstr(str1, str2));
    }
}