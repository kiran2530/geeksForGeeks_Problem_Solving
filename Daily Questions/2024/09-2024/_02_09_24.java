/*
 *  Q) Minimum Cost Path
        Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
        From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

    Example : 1
        Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
        Output: 43
        Explanation: The grid is-
        9 4 9 9
        6 7 6 4
        8 3 3 7
        7 4 9 10
        The minimum cost is-
        9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
        
    Example : 2
        Input: grid = {{4,4},{3,7}}
        Output: 14
        Explanation: The grid is-
        4 4
        3 7
        The minimum cost is- 4 + 3 + 7 = 14.
        
    Expected Time Complexity: O(n^2*log(n))
    Expected Auxiliary Space: O(n^2) 
    
Constraints:
        1 ≤ n ≤ 500
        1 ≤ cost of cells ≤ 500
 */

public class _02_09_24 {
    public static int minCost(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];

        // Initialize the starting point
        dp[0][0] = grid[0][0];

        // Fill the first row (can only come from the left)
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill the first column (can only come from above)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Fill the rest of the dp table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // The value in the bottom-right cell is the minimum cost
        return dp[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid1 = {
            {9, 4, 9, 9},
            {6, 7, 6, 4},
            {8, 3, 3, 7},
            {7, 4, 9, 10}
        };

        int[][] grid2 = {
            {4, 4},
            {3, 7}
        };

        System.out.println("Minimum cost for grid1: " + minCost(grid1)); // Output: 43
        System.out.println("Minimum cost for grid2: " + minCost(grid2)); // Output: 14
    }
}
