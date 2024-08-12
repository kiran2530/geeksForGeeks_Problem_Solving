/*
 *  Q) Sum of Middle elements of two sorted arrays
        Given 2 sorted integer arrays arr1 and arr2 of the same size. Find the sum of the middle elements of two sorted arrays arr1 and arr2.

    Example : 1
        Input: arr1 = [1, 2, 4, 6, 10], arr2 = [4, 5, 6, 9, 12]
        Output: 11
        Explanation: The merged array looks like [1, 2, 4, 4, 5, 6, 6, 9, 10, 12]. Sum of middle elements is 11 (5 + 6).
        
    Example : 2
        Input: arr1 = [1, 12, 15, 26, 38], arr2 = [2, 13, 17, 30, 45]
        Output: 32
        Explanation: The merged array looks like [1, 2, 12, 13, 15, 17, 26, 30, 38, 45]. Sum of middle elements is 32 (15 + 17).
    
    Expected Time Complexity: O(log n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 <= arr1.size() == arr2.size() <= 10^3
        1 <= arr1[i] <= 10^6
        1 <= arr2[i] <= 10^6
 */
/**
 * _12_08_24
 */
public class _12_08_24 {
    public static int SumofMiddleElements(int[] arr1, int[] arr2) {
        int totalLength = arr1.length + arr2.length;
        int i = 0, j = 0, mid = totalLength / 2, sum=0;

        if (arr1[mid-1] < arr2[0]) {
            return arr1[mid-1] + arr2[0];
        }

        for (int k = 0; k <= mid ; k++) {
            if(arr1[i] < arr2[j]) {
                if(k == mid || k == mid-1)
                    sum += arr1[i];
                i++;
            }
            else if(arr1[i] == arr2[j]) {
                if(k == mid || k == mid-1)
                    sum += arr1[i];
                i++;
                
                k++;
                if(k == mid || k == mid-1)
                    sum += arr2[j];
                j++;
            }
            else {
                if(k == mid || k == mid-1)
                    sum += arr2[j];
                j++;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 6, 7}, arr2 = {5, 7, 8, 9, 10};
        System.out.println(SumofMiddleElements(arr1, arr2));
    }
}