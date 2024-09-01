/*
 *  Q) Max sum path in two arrays
        Given two sorted arrays of distinct integers arr1 and arr2. Each array may have some elements in common with the other array. Find the maximum sum of a path from the beginning of any array to the end of any array. You can switch from one array to another array only at the common elements.
        Note:  When we switch from one array to other,  we need to consider the common element only once in the result.

    Example : 1
        Input: arr1 = [2, 3, 7, 10, 12] , arr2 = [1, 5, 7, 8]
        Output: 35
        Explanation: The path will be 1+5+7+10+12 = 35, where 1 and 5 come from arr2 and then 7 is common so we switch to arr1 and add 10 and 12.
        
    Example : 1
        Input: arr1 = [1, 2, 3] , arr2[] = [3, 4, 5]
        Output: 15
        Explanation: The path will be 1+2+3+4+5=15.
        
    Expected Time Complexity: O(m + n)
    Expected Auxiliary Space: O(1)
        
    Constraints:
        1 <= arr1.size(), arr2.size() <= 10^4
        1 <= arr1[i], arr2[i] <= 10^5
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01_09_24 {
    public static int maxPathSum(List<Integer> arr1, List<Integer> arr2) {
        // code here
        int sum1 = 0, sum2 = 0, i=0, j=0, result = 0;
        
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) < arr2.get(j)) {
                sum1 += arr1.get(i);
                i++;
            }
            else if(arr1.get(i) > arr2.get(j)){
                sum2 += arr2.get(j);
                j++;
            }
            else {
                result += (Math.max(sum1, sum2) + arr1.get(i));
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }

        }
        while(i < arr1.size())
        {
            sum1 += arr1.get(i);
            i++;
        }
        while(j < arr2.size())
        {
            sum2 += arr2.get(j);
            j++;
        }
        result += Math.max(sum1,sum2);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            List<Integer> arr1 = new ArrayList<>();
            System.out.print(" Enter 1st List element using spaces : ");
            String input = sc.nextLine();
            Scanner lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr1.add(lineScanner.nextInt());
            }
            lineScanner.close();

            List<Integer> arr2 = new ArrayList<>();
            System.out.print(" Enter 2nd List element using spaces : ");
            input = sc.nextLine();
            lineScanner = new Scanner(input);
            while (lineScanner.hasNextInt()) {
                arr2.add(lineScanner.nextInt());
            }
            lineScanner.close();

            
            int ans = maxPathSum(arr1, arr2);
            System.out.println(ans);

        sc.close();
    }
}