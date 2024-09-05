/*
 *  Missing in Array
        Given an array arr of size n−1 that contains distinct integers in the range of 1 to n (inclusive), find the missing element. The array is a permutation of size n with one element missing. Return the missing element.

    Example : 1
        Input: n = 5, arr[] = [1,2,3,5]
        Output: 4
        Explanation : All the numbers from 1 to 5 are present except 4.
        
    Example : 2
        Input: n = 2, arr[] = [1]
        Output: 2
        Explanation : All the numbers from 1 to 2 are present except 2.
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 ≤ n ≤ 10^5
        1 ≤ arr[i] ≤ n
 */
public class _05_09_24 {
    static int missingNumber(int n, int arr[]) {
        // Your Code Here
        int sum = (n*(n+1))/2;
        int temp = 0;
        for(int a : arr) {
            temp += a;
        }

        return sum - temp;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1,2,3,5};
        System.out.println(missingNumber(n, arr));
    }
}