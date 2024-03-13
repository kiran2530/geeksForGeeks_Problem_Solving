/*
 *Q) Second Largest
    Given an array Arr of size N, print the second largest distinct element from an array. If the second largest element doesn't exist then return -1.

    Example 1:
    Input: 
    N = 6
    Arr[] = {12, 35, 1, 10, 34, 1}
    Output: 34
    Explanation: The largest element of the array is 35 and the second largest element is 34.

    Example 2:
    Input: 
    N = 3
    Arr[] = {10, 5, 10}
    Output: 5
    Explanation: The largest element of the array is 10 and the second largest element is 5.
    
    Your Task:
    You don't need to read input or print anything. Your task is to complete the function print2largest() which takes the array of integers arr and n as parameters and returns an integer denoting the answer. If 2nd largest element doesn't exist then return -1.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints:
    2 ≤ N ≤ 10^5
    1 ≤ Arri ≤ 10^5
*/
public class second_largest_element {
    public static int print2largest(int arr[], int n) {
        int large = -1, second_largest_element = -1;
        for(int i=0; i<n; i++) {
            if(large < arr[i]) {
                second_largest_element = large;
                large = arr[i];
            }    
            else if(second_largest_element < arr[i] && arr[i] != large)
                second_largest_element = arr[i];
        }
        return second_largest_element;
    }
    public static void main(String[] args) {
        int[] arr = {12,35,1,36};
        int n = 4;
        System.out.println(print2largest(arr, n));
    }
}
