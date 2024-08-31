/*
 *  Q) Sorted subsequence of size 3
        You are given an array arr, you need to find any three elements in it such that arr[i] < arr[j] < arr[k] and i < j < k.
        
        Note:
        The output will be 1 if the subsequence returned by the function is present in the array arr
        If the subsequence is not present in the array then return an empty array, the driver code will print 0.
        If the subsequence returned by the function is not in the format as mentioned then the output will be -1.
        
    Example : 1
        Input: arr = [1, 2, 1, 1, 3]
        Output: 1
        Explanation: A subsequence 1 2 3 exist.
        
    Example : 2
        Input: arr = [1, 1, 3]
        Output: 0
        Explanation: No such Subsequence exist, so empty array is returned (the driver code automatically prints 0 in this case).
    
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(n)

    Constraints:
        1 <= arr.size() <= 105
        1 <= arr[i] <= 10^6
 */

import java.util.ArrayList;
import java.util.List;

/**
 * _31_08_24
 */
public class _31_08_24 {
    public static List<Integer> find3Numbers(int[] arr) {
        // code here
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j < arr.length-1; j++) {
                for (int k = j+1; k < arr.length; k++) {
                    if(arr[i] < arr[j] && arr[j] < arr[k]) {
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        return list;
                    }
                }
            }
        }

        return list;
    }

    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,1,1,3};

        List<Integer> res = find3Numbers(arr);
        if (!res.isEmpty() && res.size() != 3) {
            System.out.println(-1);
        } else {
            int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
            if (resArray.length == 0) {
                System.out.println(0);
            } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                isSubSequence(arr, resArray)) {
                System.out.println(1);
            } else {
                System.out.println(-1);
            }
        }
    }
}
