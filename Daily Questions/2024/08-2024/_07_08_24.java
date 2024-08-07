/*
 *  Q) K-th element of two Arrays
        Given two sorted arrays arr1 and arr2 and an element k. The task is to find the element that would be at the kth position of the combined sorted array.

    Example : 1
        Input: k = 5, arr1[] = [2, 3, 6, 7, 9], arr2[] = [1, 4, 8, 10]
        Output: 6
        Explanation: The final combined sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10. The 5th element of this array is 6.
        
    Example : 2
        Input: k = 7, arr1[] = [100, 112, 256, 349, 770], arr2[] = [72, 86, 113, 119, 265, 445, 892]
        Output: 256
        Explanation: Combined sorted array is - 72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892. 7th element of this array is 256.
        
    Expected Time Complexity: O(log(n) + log(m))
    Expected Auxiliary Space: O(log (n))

    Constraints:
        1 <= k<= arr1.size()+arr2.size()
        1 <= arr1.size(), arr2.size() <= 10^6
        0 <= arr1[i], arr2[i] < 10^8
 */
public class _07_08_24 {
    public static long kthElement(int k, int arr1[], int arr2[]){
        /*
        int counter = 0, idx1=0, idx2=0;
        long low = -1;
        
        if(arr1[0] < arr2[0])
            low = arr1[idx1++];
        else
            low = arr2[idx2++];
        
        counter++;
        
        if(counter == k)
            return low;

        for(int i=1; i<(arr1.length + arr2.length); i++) {
            if(idx1==arr1.length || idx2 == arr2.length)
                break;
            counter++;
            if(arr1[idx1] <= arr2[idx2])
                low = arr1[idx1++];
            else
                low = arr2[idx2++];
            
            if(counter == k)
                return low;
        }
        
        while (idx1 != arr1.length) {
            counter++;
            low = arr1[idx1];
            if(counter == k)
                return low;
        }
        while (idx2 != arr2.length) {
            counter++;
            low = arr2[idx2];
            if(counter == k)
                return low;
        }
        return low;
        */

        int l = 0;
        int r = 0;
 
        while (l < arr1.length && r < arr2.length) {
            if (k == 1) {
                return (long)(Math.min(arr1[l], arr2[r]));
            }
            if (arr1[l] < arr2[r]) {
                l++;
            } else {
                r++;
            }
            k--;
        }
        
        while (l < arr1.length) {
            if (k == 1) {
                return (long)(arr1[l]);
            }
            l++;
            k--;
        }
        
        while (r < arr2.length) {
            if (k == 1) {
                return (long)(arr2[r]);
            }
            r++;
            k--;
        }
        
        return 0;
    }
    public static void main(String[] args) {
        int k = 7;
        int[] arr1 = {100, 112, 256, 349, 770}, arr2 = {72, 86, 113, 119, 265, 445, 892};

        System.out.println(kthElement(k, arr1, arr2));
    }
}
