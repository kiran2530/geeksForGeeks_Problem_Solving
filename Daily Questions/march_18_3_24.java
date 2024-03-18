/*
 * Q) 18-3-2024 : Level order traversal
    Given a root of a binary tree with n nodes, find its level order traversal.
    Level order traversal of a tree is breadth-first traversal for the tree.

    Example 1:
    Input:
        1
    /   \ 
    3     2
    
    Output: 1 3 2
    
    Example 2:
    Input:
            10
        /      \
        20       30
    /   \
    40   60
    
    Output: 10 20 30 40 60
    
    Your Task:
        You don't have to take any input. Complete the function levelOrder() that takes the root node as input parameter and returns a list of integers containing the level order traversal of the given Binary Tree.

    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(n)

    Constraints:
        1 ≤ n ≤ 105
        0 ≤ Data of a node ≤ 109
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class march_18_3_24 {
    class Node {
        int data;
        Node left, right;
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
    static ArrayList <Integer> levelOrder(Node root) {
         ArrayList<Integer> a=new ArrayList<>();
        Queue<Node> s = new LinkedList<>();
        s.add(root);
        while(!s.isEmpty())
        {
            Node t=s.peek();
            if(t.left!=null)
                s.add(t.left);
            if(t.right!=null)
                s.add(t.right);
            a.add(t.data);
            s.remove();
        }
        return a;
        
    }
    public static void main(String[] args) {
        
    }
}
