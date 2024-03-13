/*
 * Q) Kth smallest element
    Given an array arr[] and an integer K where K is smaller than size of array, the task is to find the Kth smallest element in the given array. It is given that all array elements are distinct.

    Note :-  l and r denotes the starting and ending index of the array.

    Example 1:
    Input:
    N = 6
    arr[] = 7 10 4 3 20 15
    K = 3
    L=0 R=5
    Output : 7
    Explanation :
    3rd smallest element in the given array is 7.
    
    Example 2:
    Input:
    N = 5
    arr[] = 7 10 4 20 15
    K = 4 L=0 R=4
    Output : 15
    Explanation :
    4th smallest element in the given array is 15.
    
    Your Task:
    You don't have to read input or print anything. Your task is to complete the function kthSmallest() which takes the array arr[], integers l and r denoting the starting and ending index of the array and an integer K as input and returns the Kth smallest element.
    
    Expected Time Complexity: O(n*log(n) )
    Expected Auxiliary Space: O(log(n))
    
    Constraints:
    1 <= N <= 10^5
    L==0
    R==N-1
    1<= arr[i] <= 10^5
    1 <= K <= N
*/
import java.util.Arrays;

public class Kth_small_element {
    public static int kthSmallest(int[] arr, int l, int r, int k) { 
        Arrays.sort(arr);
        return arr[k-1];
    }
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int n = 6, k = 3 , l = 0, r = n-1;
        System.out.println(kthSmallest(arr, l, r, k));
    }
}
