/*
 *  Q) Maximize The Cut Segments
        Difficulty: MediumAccuracy: 24.29%Submissions: 226K+Points: 4
        Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.
        After performing all the cut operations, your total number of cut segments must be maximum. Return the maximum number of cut segments possible.
        Note: if no segment can be cut then return 0.

    Example : 1
        Input: n = 4, x = 2, y = 1, z = 1
        Output: 4
        Explanation: Total length is 4, and the cut
        lengths are 2, 1 and 1.  We can make
        maximum 4 segments each of length 1.
        
    Example : 2
        Input: n = 5, x = 5, y = 3, z = 2
        Output: 2
        Explanation: Here total length is 5, and
        the cut lengths are 5, 3 and 2. We can
        make two segments of lengths 3 and 2.
    
    Expected Time Complexity : O(n)
    Expected Auxiliary Space: O(n)

    Constraints
        1 <= n, x, y, z <= 10^4
 */

import java.util.Arrays;

/**
 * _16_08_24
 */
public class _16_08_24 {
    public static int maximizeCuts(int n, int x, int y, int z)
    {
       
       int[] dp = new int[n+1];
       Arrays.fill(dp, -1);
       int res = cuts(n, x, y, z, dp);
       
       return res<0?0:res;
    }
    
    public static int cuts(int n, int x, int y, int z, int[] dp)
    {
       if(n==0) return 0;
       if(n<0) return Integer.MIN_VALUE;
       if(dp[n]!=-1) return dp[n];
       
       int max = 1+Math.max(cuts(n-x, x, y, z, dp), Math.max(cuts(n-y, x, y, z, dp),cuts(n-z, x, y, z, dp)));
    
       return dp[n]=max;
    }
    public static void main(String[] args) {
        int n = 4, x = 2, y = 1, z = 1;
        System.out.println(maximizeCuts(n, x, y, z));   
    }
}