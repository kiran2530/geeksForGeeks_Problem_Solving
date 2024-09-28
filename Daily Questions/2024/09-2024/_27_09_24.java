/*
 *  Q) K Sized Subarray Maximum
        Given an array arr[] and an integer k. Find the maximum for each and every contiguous subarray of size k.

    Example : 1
        Input: k = 3, arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
        Output: [3, 3, 4, 5, 5, 5, 6] 
        Explanation: 
        1st contiguous subarray = [1 2 3] max = 3
        2nd contiguous subarray = [2 3 1] max = 3
        3rd contiguous subarray = [3 1 4] max = 4
        4th contiguous subarray = [1 4 5] max = 5
        5th contiguous subarray = [4 5 2] max = 5
        6th contiguous subarray = [5 2 3] max = 5
        7th contiguous subarray = [2 3 6] max = 6

    Example : 2
        Input: k = 4, arr[] = [8, 5, 10, 7, 9, 4, 15, 12, 90, 13]
        Output: [10, 10, 10, 15, 15, 90, 90]
        Explanation: 
        1st contiguous subarray = [8 5 10 7], max = 10
        2nd contiguous subarray = [5 10 7 9], max = 10
        3rd contiguous subarray = [10 7 9 4], max = 10
        4th contiguous subarray = [7 9 4 15], max = 15
        5th contiguous subarray = [9 4 15 12], max = 15
        6th contiguous subarray = [4 15 12 90], max = 90
        7th contiguous subarray = {15 12 90 13}, max = 90
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(k)

    Constraints:
        1 ≤ sizeof(arr) ≤ 10^6
        1 ≤ k ≤ sizeof(arr)
        0 ≤ arr[i] ≤ 10^9
 */

import java.util.ArrayList;

public class _27_09_24 {
    public static int findMax(int i, int j, int[] arr) {
        int max = 0, idx = -1;
        for(int k = i; k < j; k++) {
            if(max < arr[k]) {
                max = arr[k];
                idx = k;
            }
        }
        return idx;
    }
    public static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = findMax(0, k, arr);
        ans.add(arr[max]);
        for (int i = 1; i < arr.length-k+1; i++) {
            System.out.println(max);
            if(max < i) {
                max = findMax(i, i+k, arr);
                ans.add(arr[max]);
            }
            else{
                max = Math.max(arr[max], arr[i+k-1]);
                ans.add(arr[max]);
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};

        System.out.println(max_of_subarrays(k, arr));
    }
}