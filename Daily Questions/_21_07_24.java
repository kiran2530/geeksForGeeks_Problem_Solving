/*
    Q) 21_07_24 : Maximum product subset of an array
        Given an array arr. The task is to find and return the maximum product possible with the subset of elements present in the array.

    Note:

    The maximum product can be a single element also.
    Since the product can be large, return it modulo 109 + 7.
    Examples:
        Input: arr[] = [-1, 0, -2, 4, 3]
        Output: 24
        Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
        
        Input: arr[] = [-1, 0]
        Output: 0
        Explanation: Maximum product will be ( -1 * 0) = 0
        
        Input: arr[] = [5]
        Output: 5
        Explanation: Maximum product will be 5.
    
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
    1 <= arr.size() <= 2 * 104
    -10 <= arr[i] <= 10
*/

import java.util.*;

public class _21_07_24 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        if (arr.size() == 1) return arr.get(0);
        
        long prod = 1;
        int zeroCount = 0, nonZeroCount = 0;
        int maxNegative = Integer.MIN_VALUE;
        final int MOD = 1000000007;

        for (int num : arr) {
            if (num != 0) {
                prod = (prod * num) % MOD;
                nonZeroCount = 1;
            } else {
                zeroCount = 1;
            }
            if (num < 0 && num > maxNegative) {
                maxNegative = num;
            }
        }

        if (nonZeroCount != 1) return 0;
        if (arr.size() == 2 && zeroCount == 1 && prod < 0) return 0;
        if (prod < 0) prod /= maxNegative;
        
        return prod;
    }
}