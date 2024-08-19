/*
 *  Q) Kth Smallest
        Given an array arr[] and an integer k where k is smaller than the size of the array, the task is to find the kth smallest element in the given array. It is given that all array elements are distinct.
        Follow up: Don't solve it using the inbuilt sort function.

    Example : 1
        Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
        Output:  7
        Explanation: 3rd smallest element in the given array is 7.
        
    Example : 2
        Input: arr[] = [7, 10, 4, 20, 15], k = 4 
        Output:  15
        Explanation: 4th smallest element in the given array is 15.
        
    Expected Time Complexity: O(n+(max_element) )
    Expected Auxiliary Space: O(max_element)
        
    Constraints:
        1 <= arr.size <= 10^6
        1<= arr[i] <= 10^6
        1 <= k <= n
 */

import java.util.Arrays;

public class _19_08_24 {
    public static int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k-1];
    }
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        System.out.println(kthSmallest(arr, k));
    }
}