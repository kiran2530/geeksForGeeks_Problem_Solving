/*
 *  Q) Square root of a number
        Given an integer n, find the square root of n. If n is not a perfect square, then return the floor value.
        Floor value of any number is the greatest Integer which is less than or equal to that number
        
    Example : 1
        Input: n = 5
        Output: 2
        Explanation: Since, 5 is not a perfect square, floor of square_root of 5 is 2.
        
    Example : 1
        Input: n = 4
        Output: 2
        Explanation: Since, 4 is a perfect square, so its square root is 2.
        
    Expected Time Complexity: O(logn)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ n ≤ 10^7
 */

public class _13_08_24 {
    static long floorSqrt(long n) {
        long i = 0, j = n, ans = 0;;
        while (i<=j) {
            if((i * i) <= n) {
                ans = i;
                i++;
            }
            else 
                j--;
        }

        return ans;
    }
    public static void main(String[] args) {
        System.out.println(floorSqrt(1));
    }
}