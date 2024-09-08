/*
 *  Minimum Jumps
        Given an array arr[] of non-negative integers. Each array element represents the maximum length of the jumps that can be made forward from that element. This means if arr[i] = x, then we can jump any distance y such that y ≤ x.
        Find the minimum number of jumps to reach the end of the array starting from the first element. If an element is 0, then you cannot move through that element.
        Note:  Return -1 if you can't reach the end of the array.

    Examples : 1
        Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
        Output: 3 
        Explanation:First jump from 1st element to 2nd element with value 3. From here we jump to 5th element with value 9, and from here we will jump to the last. 
        
    Examples : 2
        Input: arr = {1, 4, 3, 2, 6, 7}
        Output: 2 
        Explanation: First we jump from the 1st to 2nd element and then jump to the last element.
        
    Examples : 3
        Input: arr = {0, 10, 20}
        Output: -1
        Explanation: We cannot go anywhere from the 1st element.
        
    Expected Time Complexity: O(n)
    Expected Space Complexity: O(1)

    Constraints:
        0 ≤ arr[i] ≤ 10^5
        2 ≤ arr.size() ≤ 10^6
 */
public class _08_09_24 {
    public static int minJumps(int[] arr) {
        // your code here
        /*
        int steps = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0)
                return -1;
                
            steps++;

            if(i + arr[i] < arr.length-1) {
                int a = arr[i];
                while (a > 0) {
                    if(arr[i+a] != 0){
                        i = i + a-1;
                        break;
                    }
                    a--;
                }
                if(a==0)
                    return -1;
            }
            else
                return steps;
        }
        return steps;
        */

        if (arr[0] == 0) {
            return -1;
        }
        
        int jump = 1;
        int pos = 0;
        while (pos + arr[pos] < arr.length - 1) {
            int max = 0;
            int tpos = pos;
            for (int i = pos + 1; i <= pos + arr[pos]; i++) {
                if (i > arr.length) {
                    break;
                }
                if (max < i + arr[i]) {
                    max = i + arr[i];
                    tpos = i;
                }
            }
            if (pos == tpos) {
                return -1;
            } else {
                pos = tpos;
                jump += 1;
            }
        }
        return jump;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2, 6, 7};
        System.out.println(minJumps(arr));
    }
}