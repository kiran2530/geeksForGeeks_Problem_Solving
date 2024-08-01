/*
 *  o) Spirally traversing a matrix
        You are given a rectangular matrix, and your task is to return an array while traversing the matrix in spiral form.

    Examples : 1
        Input: matrix[][] = [[1, 2, 3, 4],
                        [5, 6, 7, 8],
                        [9, 10, 11, 12],
                        [13, 14, 15,16]]
        Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
        Explanation:

    Examples : 1
        Input: matrix[][] = [[1, 2, 3, 4],
                        [5, 6, 7, 8],
                        [9, 10, 11, 12]]
        Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
        Explanation: Applying same technique as shown above, output for the 2nd testcase will be 1 2 3 4 8 12 11 10 9 5 6 7.
    
    Expected Time Complexity: O(n2)
    Expected Auxiliary Space: O(n2)

    Constraints:
        1 <= matrix.size(), matrix[0].size() <= 100
        0 <= matrix[i][j]<= 100
 */

import java.util.ArrayList;

public class _01_08_24 {
    public static ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        // code here
        ArrayList<Integer> result=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0,col=-1;
        int direction=1;
        while(n>0&&m>0){
            for(int i=0;i<m;i++){
                col+=direction;
                result.add(matrix[row][col]);
            }
            n--;
            for(int i=0;i<n;i++){
                row+=direction;
                result.add(matrix[row][col]);
            }
            m--;
            direction*=-1;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };

        System.out.println(spirallyTraverse(matrix));
    }
}
