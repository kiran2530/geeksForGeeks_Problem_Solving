/* 
 * Rat in a Maze Problem - I
        Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
        Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

    Examples: 1
        Input: mat[][] = [[1, 0, 0, 0],
                        [1, 1, 0, 1], 
                        [1, 1, 0, 0],
                        [0, 1, 1, 1]]
        Output: DDRDRR DRDDRR
        Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
        
    Examples: 2    
        Input: mat[][] = [[1, 0],
                        [1, 0]]
        Output: -1
        Explanation: No path exists and destination cell is blocked.
        Expected Time Complexity: O(3n^2)
        Expected Auxiliary Space: O(l * x)
        Here l = length of the path, x = number of paths.

    Constraints:
        2 ≤ n ≤ 5
        0 ≤ mat[i][j] ≤ 1
*/
import java.util.*;;

public class _30_07_24 {
    public static ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res=new ArrayList<>();
        recurse(mat,0,0,"",res);
        return res;
    }
    static void recurse(int[][] mat,int r,int c,String res,ArrayList<String> ans){
        if (r==mat.length-1 && c==mat[0].length-1 && mat[r][c]==1){
            ans.add(res);
            return;
        }
        if (r<0 || r>=mat.length || c<0 || c>=mat[0].length) return;
        if (mat[r][c]==0 || mat[r][c]==-1) return;
        mat[r][c]=-1;
     
        recurse(mat,r-1,c,res+"U",ans);
        recurse(mat,r+1,c,res+"D",ans);
        recurse(mat,r,c-1,res+"L",ans);
        recurse(mat,r,c+1,res+"R",ans);
        mat[r][c]=1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            ArrayList<String> res = findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        sc.close();
    }
}
