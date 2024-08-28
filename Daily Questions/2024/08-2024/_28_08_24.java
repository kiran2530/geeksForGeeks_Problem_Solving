/*
 *  Q) Sorting Elements of an Array by Frequency
        Given an array of integers arr, sort the array according to the frequency of elements, i.e. elements that have higher frequency comes first. If the frequencies of two elements are the same, then the smaller number comes first.

    Example : 1
        Input: arr[] = [5, 5, 4, 6, 4]
        Output: [4, 4, 5, 5, 6]
        Explanation: The highest frequency here is 2. Both 5 and 4 have that frequency. Now since the frequencies are the same the smaller element comes first. So 4 4 comes first then comes 5 5. Finally comes 6. The output is 4 4 5 5 6.
        
    Example : 2
        Input: arr[] = [9, 9, 9, 2, 5]
        Output: [9, 9, 9, 2, 5]
        Explanation: The highest frequency here is 3. Element 9 has the highest frequency So 9 9 9 comes first. Now both 2 and 5 have the same frequency. So we print smaller elements first. The output is 9 9 9 2 5.
        
    Expected Time Complexity: O(n*logn)
    Expected Space Complexity: O(n)

    Constraints:
        1 ≤ arr.size() ≤ 10^5
        1 ≤ arr[i]≤ 10^5
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _28_08_24 {

  public static ArrayList<Integer> sortByFreq(int arr[]) {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> ans = new ArrayList<>();

    for (int i = 0; i < arr.length; i++)
      map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
    // System.out.println(map);

    for (int i = 0; i < arr.length; i++) 
        ans.add(arr[i]);

    Collections.sort(
      ans,
      (a, b) -> {
        int freqA = map.get(a);
        int freqB = map.get(b);
        if (freqA != freqB) {
          //simply return whose freq is more
          return freqB - freqA;
        } else {
          //if freq is same return who ever is small
          return a - b;
        }
      }
    );

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 5, 4, 6, 4 };
    System.out.println(sortByFreq(arr));
  }
}
