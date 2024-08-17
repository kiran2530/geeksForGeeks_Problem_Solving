/*
 *  Q) Product array puzzle
        Given an array nums[], construct a Product Array nums[] such that nums[i] is equal to the product of all the elements of nums except nums[i].

    Example : 1
        Input: nums[] = [10, 3, 5, 6, 2]
        Output: [180, 600, 360, 300, 900]
        Explanation: For i=0, P[i] = 3*5*6*2 = 180.
        For i=1, P[i] = 10*5*6*2 = 600.
        For i=2, P[i] = 10*3*6*2 = 360.
        For i=3, P[i] = 10*3*5*2 = 300.
        For i=4, P[i] = 10*3*5*6 = 900.
        
    Example : 2
        Input: nums[] = [12,0]
        Output: [0, 12]
        
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(n)

    Constraints:
        1 <= nums.size() <= 1000
        0 <= nums[i] <= 200
        nums[i] may contain duplicates.
 */

public class _17_08_24 {
    public static long[] productExceptSelf(int nums[]) {
        long product = 1;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                product *= nums[i];
            else
                zeroCount++;
        }
        
        long[] ans = new long[nums.length];

        for (int i = 0; i < ans.length; i++) {
            if(zeroCount > 1)
                ans[i] = 0;
            else if(zeroCount == 1 && nums[i] != 0)
                ans[i] = 0;
            else if(zeroCount == 1 && nums[i] == 0)
                ans[i] = product;
            else
                ans[i] = product/nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {12,0};

        long[] ans = productExceptSelf(nums);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}