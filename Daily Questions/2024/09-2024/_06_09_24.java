/*
 *  Q) Kadane's Algorithm
        Given an integer array arr[]. Find the contiguous sub-array(containing at least one number) that has the maximum sum and return its sum.

    Example : 1
        Input: arr[] = [1, 2, 3, -2, 5]
        Output: 9
        Explanation: Max subarray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
    
    Example : 2
        Input: arr[] = [-1, -2, -3, -4]
        Output: -1
        Explanation: Max subarray sum is -1 of element (-1)
    
    Example : 3
        Input: arr[] = [5, 4, 7]
        Output: 16
        Explanation: Max subarray sum is 16 of element (5, 4, 7)
    
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ arr.size() ≤ 10^5
        -107 ≤ arr[i] ≤ 10^7
 */
public class _06_09_24 {
    public static int maxSubarraySum(int[] arr) {
        int sum = 0, ans = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);
            if(sum<0){
                sum = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};

        System.out.println(maxSubarraySum(arr));
    }
}