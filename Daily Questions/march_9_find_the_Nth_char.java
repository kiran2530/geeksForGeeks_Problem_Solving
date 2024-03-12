/*
 * march 9 : Find the N-th character 
    Given a binary string s. Perform r iterations on string s, where in each iteration 0 becomes 01 and 1 becomes 10. Find the nth character (considering 0 based indexing) of the string after performing these r iterations (see examples for better understanding).

    Example 1:
    Input:
    s = "1100"
    r = 2
    n = 3
    Output:
    1
    Explanation: 
    After 1st iteration s becomes "10100101".
    After 2nd iteration s becomes "1001100101100110".
    Now, we can clearly see that the character at 3rd index is 1, and so the output.
    
    Example 2:
    Input:
    s = "1010"
    r = 1
    n = 2
    Output:
    0
    Explanation : 
    After 1st iteration s becomes "10011001".
    Now, we can clearly see that the character at 2nd index is 0, and so the output.
    Your task:
    You don't need to read input or print anything. Your task is to complete the function nthCharacter() which takes the string s and integers r and n as input parameters and returns the n-th character of the string after performing r operations on s.
    
    Expected Time Complexity: O(r*|s|)
    Expected Auxilary Space: O(|s|)
    
    Constraints:
    1 ≤ |s| ≤ 103
    1 ≤ r ≤ 20
    0 ≤ n < |s|
*/
public class march_9_find_the_Nth_char {
    public static char nthCharacter(String s, int r, int n) {
        
        for(int i=0; i<r; i++) {
            String s1 = "";
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == '1')
                     s1 += "10";
                else
                    s1 += "01";
            }
            s = s1;
        }
        return s.charAt(n);

        // StringBuilder sb1 = new StringBuilder(s);
        // int m = s.length();
        // for(int i=0;i<r;i++){
        //     StringBuilder sb2 = new StringBuilder();
        //     for(int j=0;j<m;j++){
        //         char c = sb1.charAt(j);
        //         // System.out.println(c);
        //         if(c == '0') sb2.append("01");
        //         else sb2.append("10");
        //     }
        //     sb1 = sb2;
        // }
        // // System.out.println(sb1);
        // return sb1.charAt(n);
    }

    public static void main(String[] args) {
        String s = "1100";
        int r = 2;
        int n = 3;

        System.out.println(nthCharacter(s, r, n));
    }
}
