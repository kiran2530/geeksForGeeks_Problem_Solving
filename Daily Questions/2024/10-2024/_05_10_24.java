/*
 *  Q) Not a subset sum
        Given a sorted array arr[] of positive integers, find the smallest positive integer such that it cannot be represented as the sum of elements of any subset of the given array set.

    Examples:
        Input: arr[] = [1, 2, 3]
        Output: 7
        Explanation: 7 is the smallest positive number for which no subset is there with sum 7.
        
        Input: arr[] = [3, 6, 9, 10, 20, 28]
        Output: 1
        Explanation: 1 is the smallest positive number for which no subset is there with sum 1.
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints
        1 <= arr.size() <= 10^6
        1 <= arr[i] <= 10^8
 */
public class _05_10_24 {
    public static long findSmallest(int[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if(sum+1 < arr[i])
                return sum+1;
            sum += arr[i];
        }
        return sum+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(findSmallest(arr));
    }
}
