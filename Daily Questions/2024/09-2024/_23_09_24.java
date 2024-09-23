/*
 * Q) Missing And Repeating
        Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing and one number 'B' occurs twice in array. Find numbers A and B.

    Examples
        Input: arr[] = [2, 2]
        Output: 2 1
        Explanation: Repeating number is 2 and smallest positive missing number is 1.
        
        Input: arr[] = [1, 3, 3] 
        Output: 3 2
        Explanation: Repeating number is 3 and smallest positive missing number is 2.
            
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        2 ≤ n ≤ 10^5
        1 ≤ arr[i] ≤ n
*/

import java.util.HashSet;

public class _23_09_24 {

  public static int[] findTwoElement(int arr[]) {
    int n = arr.length;
    int repeated = 0, miss = 0;

    HashSet<Integer> set = new HashSet<>();

    for (int i = 0; i < n; i++) {
        if(!set.contains(arr[i]))
            set.add(arr[i]);
        else 
            repeated = arr[i];
    }
    
    for (int i = 1; i <= n; i++) {
        if(!set.contains(i))
            miss = i;
    }

    return new int[] {repeated, miss};
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 3 };

    int[] res = findTwoElement(arr);
    System.out.println(res[0] + " " + res[1]);
  }
}
