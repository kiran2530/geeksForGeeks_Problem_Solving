/* 
 *  Q) Longest Common Prefix of Strings
        Given an array of strings arr. Return the longest common prefix among all strings present in the array. If there's no prefix common in all the strings, return "-1".

    Examples :1
        Input: arr[] = ["geeksforgeeks", "geeks", "geek", "geezer"]
        Output: gee
        Explanation: "gee" is the longest common prefix in all the given strings.
    
    Examples : 2
        Input: arr[] = ["hello", "world"]
        Output: -1
        Explanation: There's no common prefix in the given strings.
        
    Expected Time Complexity: O(n*min(|arri|))
    Expected Space Complexity: O(min(|arri|))

    Constraints:
        1 ≤ |arr| ≤ 10^3
        1 ≤ |arr[i]| ≤ 10^3
*/

import java.util.Arrays;

public class _31_07_24 {
    public static String longestCommonPrefix(String arr[]) {
        // code here
        int flag = 1;
        Arrays.sort(arr);
        String longPrefix = "";

        for(int i=0; i< arr[0].length(); i++) {
            for(int j=1; j<arr.length; j++) {
                if(arr[0].charAt(i) != arr[j].charAt(i)){
                    flag = 0;
                    break;
                }
            }
            if(flag == 0)
                break;
            else {
                longPrefix += arr[0].charAt(i);
            }
        }

        if(longPrefix != "")
            return longPrefix;

        return "-1";
    }

    public static void main(String[] args) {
        String arr[] = {"hello", "world"};

        System.out.println(longestCommonPrefix(arr));
    }
}
