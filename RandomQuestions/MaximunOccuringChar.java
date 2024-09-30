/*
 * Q) Maximum Occuring Character
        Given a string str of lowercase alphabets. The task is to find the maximum occurring character in the string str. If more than one character occurs the maximum number of time then print the lexicographically smaller character.

    Example 1:
        Input:
        str = testsample
        Output: e
        Explanation: e is the character which
        is having the highest frequency.
        
    Example 2:
        Input:
        str = output
        Output: t
        Explanation:  t and u are the characters
        with the same frequency, but t is
        lexicographically smaller.
        Your Task:
        The task is to complete the function getMaxOccuringChar() which returns the character which is most occurring.

        Expected Time Complexity: O(N).
        Expected Auxiliary Space: O(Number of distinct characters).
        Note: N = |s|

    Constraints:
        1 ≤ |s| ≤ 100
 */

import java.util.HashMap;

public class MaximunOccuringChar {

  public static char getMaxOccuringChar(String line) {
    HashMap<Character, Integer> map = new HashMap<>();
    int max = 0;
    char ans = ' ';

    for (int i = 0; i < line.length(); i++) {
      char temp = line.charAt(i);
      map.put(temp, map.getOrDefault(temp, 0) + 1);

      if (map.get(temp) == max) {
        if (temp < ans) ans = temp;
      }
      if (map.get(temp) > max) {
        max = map.get(temp);
        ans = temp;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String str = "testsample";
    System.out.println(getMaxOccuringChar(str));
  }
}
