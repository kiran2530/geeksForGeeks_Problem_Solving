/*
 * Q) 23-03-2024 : Fibonacci series up to Nth term
    You are given an integer n, return the fibonacci series till the nth(0-based indexing) term. Since the terms can become very large return the terms modulo 10^9 + 7.

    Example 1:
    Input:
    n = 5
    Output: 0 1 1 2 3 5
    Explanation:
    0 1 1 2 3 5 is the Fibonacci series up to the 5th term.
    
    Example 2:
    Input:
    n = 10
    Output: 0 1 1 2 3 5 8 13 21 34 55
    Explanation:
    0 1 1 2 3 5 8 13 21 34 55 is the Fibonacci series up to the 10th term.
    
    Your Task:
    You don't need to read input or print anything. Your task is to complete the function Series() which takes an Integer n as input and returns a Fibonacci series up to the nth term.

    Expected Time Complexity: O(n)
    Expected Space Complexity: O(n)

    Constraint:
    1 <= n <= 10^5
*/
public class march_23_3_24 {
    public static int[] Series(int n) {
        // code here
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        
        for(int i=2; i<=n; i++) {
            result[i] = result[i-1] + result[i-2];
            result[i] = result[i] % (int)(Math.pow(10,9)+7);
        }
        return result;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] result = Series(n);

        for(int i=0; i<=n; i++)
            System.out.print(result[i] + " ");
    }
}
