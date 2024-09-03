/*
 *  Q) Minimum number of deletions and insertions
        Given two strings str1 and str2. The task is to remove or insert the minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.

    Example : 1
        Input: str1 = "heap", str2 = "pea"
        Output: 3
        Explanation: 2 deletions and 1 insertion.
        p and h deleted from heap. Then, p is inserted at the beginning.
        One thing to note, though p was required yet it was removed/deleted first from its position and then it is inserted to some other position. Thus, p contributes one to the deletion_count and one to the insertion_count.
        
    Example : 2
        Input : str1 = "geeksforgeeks", str2 = "geeks"
        Output: 8
        Explanation: 8 deletions, i.e. remove all characters of the string "forgeeks".
        
    Expected Time Complexity: O(|str1|*|str2|)
    Expected Space Complexity: O(|str1|*|str2|)

    Constraints:
        1 ≤ |str1|, |str2| ≤ 1000
        All the characters are lowercase English alphabets
 */
public class _03_09_24 {

  public static int longestCommonSubStr(String s1, String s2) {
    int res = 0;
    int m = s1.length();
    int n = s2.length();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int curr = 0;
        while (
          (i + curr) < m &&
          (j + curr) < n &&
          s1.charAt(i + curr) == s2.charAt(j + curr)
        ) {
          curr++;
        }
        res = Math.max(res, curr);
      }
    }
    return res;
  }

  public static int minOperations(String str1, String str2) {
    // Your code goes here
    int n = str1.length(), m = str2.length();

    int longSubStrLength = longestCommonSubStr(str1, str2);

    int ans = 0;

    ans += m - longSubStrLength;
    ans += n - longSubStrLength;

    return ans;
  }

  public static void main(String[] args) {
    String str1 = "heap", str2 = "pea";
    System.out.println(minOperations(str1, str2));
  }
}
