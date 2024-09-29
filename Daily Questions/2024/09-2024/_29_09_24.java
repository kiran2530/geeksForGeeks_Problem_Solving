/*
    Q) Total count
        You are given an array arr[] of positive integers and a threshold value k. For each element in the array, divide it into the minimum number of small integers such that each divided integer is less than or equal to k. Compute the total number of these integer across all elements of the array.

    Example : 1
        Input: k = 3, arr[] = [5, 8, 10, 13]
        Output: 14
        Explanation: Each number can be expressed as sum of different numbers less than or equal to k as 5 (3 + 2), 8 (3 + 3 + 2), 10 (3 + 3 + 3 + 1), 13 (3 + 3 + 3 + 3 + 1). So, the sum of count of each element is (2+3+4+5)=14.
        
    Example : 2
        Input: k = 4, arr[] = [10, 2, 3, 4, 7]
        Output: 8
        Explanation: Each number can be expressed as sum of different numbers less than or equal to k as 10 (4 + 4 + 2), 2 (2), 3 (3), 4 (4) and 7 (4 + 3).So, the sum of count of each element is (3 + 1 + 1 + 1 + 2) = 8.
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ arr.size() ≤ 10^5
        0 ≤ arr[i] ≤ 10^5
        1 ≤ k ≤ 10^5
*/

public class _29_09_24 {
    public static int totalCount(int k, int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % k == 0) {
                sum += arr[i]/k;
            }
            else {
                sum += arr[i]/k + 1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 7};
        int k = 4;
        
        System.out.println(totalCount(k, arr));
    }
}