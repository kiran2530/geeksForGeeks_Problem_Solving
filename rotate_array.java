/*
 * Q) Rotate Array
    Given an unsorted array arr[] of size N. Rotate the array to the left (counter-clockwise direction) by D steps, where D is a positive integer. 

    Example 1:
    Input: N = 5, D = 2
    arr[] = {1,2,3,4,5}
    Output: 3 4 5 1 2
    Explanation: 1 2 3 4 5  when rotated by 2 elements, it becomes 3 4 5 1 2.
    
    Example 2:
    Input: N = 10, D = 3
    arr[] = {2,4,6,8,10,12,14,16,18,20}
    Output: 8 10 12 14 16 18 20 2 4 6
    Explanation: 2 4 6 8 10 12 14 16 18 20 when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
    
    Your Task:
    You need not print or read anything. You need to complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements. The array must be modified in-place without using extra space. 

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(1)

    Constraints:
    1 <= N <= 10^6
    1 <= D <= 10^6
    0 <= arr[i] <= 10^5
*/
public class rotate_array {
    public static void rotateArr(int arr[], int d, int n) {
        int[] a = new int[n];
        d = d%n;
        int idx = 0;
        for(int i = d; i<n; i++)
            a[idx++] = arr[i];
        for(int i=0; i<d; i++)
            a[idx++] = arr[i];
        for(int i=0; i<n; i++)
            arr[i] = a[i];
    }
    public static void main(String[] args) {
        int n = 5, d = 2;
        int[] arr = {1,2,3,4,5};
        rotateArr(arr, d, n);
        for(int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
    }
}
