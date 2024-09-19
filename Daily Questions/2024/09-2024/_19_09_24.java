/*
 *  Q) Reverse Words
        Given a String str, reverse the string without reversing its individual words. Words are separated by dots.
        Note: The last character has not been '.'. 

    Example : 1
        Input: str = i.like.this.program.very.much
        Output: much.very.program.this.like.i
        Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i

    Example : 2
        Input: str = pqr.mno
        Output: mno.pqr
        Explanation: After reversing the whole string , the input string becomes mno.pqr

    Expected Time Complexity: O(|str|)
    Expected Auxiliary Space: O(|str|)

    Constraints:
        1 <= |str| <= 10^5
 */

public class _19_09_24 {

  public static String reverseWords(String str) {
    String[] separateString = str.split("\\.");
    int dot = separateString.length - 1 ;
    str = "";

    for (int i = separateString.length - 1; i >= 0; i--) {
      str += separateString[i];
      if (dot > 0) {
        str += ".";
        dot--;
      }
    }
    return str;
  }

  public static void main(String[] args) {
    String str = "i.like.this.program.very.much";
    System.out.println(reverseWords(str));
  }
}
