/*
 *  Q) Bottom View of Binary Tree
        Given a binary tree, return an array where elements represent the bottom view of the binary tree from left to right.
        Note: If there are multiple bottom-most nodes for a horizontal distance from the root, then the latter one in the level traversal is considered. For example, in the below diagram, 3 and 4 are both the bottommost nodes at a horizontal distance of 0, here 4 will be considered.

                              20
                            /    \
                           8       22
                         /   \    /   \
                        5      3 4     25
                              /    \      
                            10       14

        For the above tree, the output should be 5 10 4 14 25.

    Example : 1
        Input:
              1
            /   \
           3     2
        Output: 3 1 2
        Explanation: First case represents a tree with 3 nodes and 2 edges where root is 1, left child of 1 is 3 and right child of 1 is 2.

        Thus bottom view of the binary tree will be 3 1 2.
        
    Example : 2
        Input:
                10
              /    \
             20    30
            /  \
          40   60
        Output: 40 20 60 30
    
    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(n)

    Constraints:
        1 <= Number of nodes <= 10^5
        1 <= Data of a node <= 10^5
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList; 
import java.util.Queue;
import java.io.*;

class Node
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
 
    // Constructor of tree node
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}


public class _05_08_24 {
    //  My logic and functions as a solution of this problem statement ----------------------------------------------------------
    static int maxLeft;
    static int maxRight;
    static void solve(Node root,int pos,int height,HashMap<Integer,int[]> map){
        if(root==null)
            return;
        maxLeft=Math.min(maxLeft,pos);
        maxRight=Math.max(maxRight,pos);
        if(map.get(pos)==null || map.get(pos)[0]<=height)
        map.put(pos,new int[]{height,root.data});
        solve(root.left,pos-1,height+1,map);
        solve(root.right,pos+1,height+1,map);
    }
    public static ArrayList <Integer> bottomView(Node root)
    {
        if(root==null)
            return new ArrayList<Integer>();
        maxLeft=0;
        maxRight=0;
        HashMap<Integer,int[]> map=new HashMap<>();
        solve(root,0,0,map);
        ArrayList<Integer> ans=new ArrayList<>();
        while(maxLeft<=maxRight)
            ans.add(map.get(maxLeft++)[1]);
        return ans;
    }

// --------------------------------------------------------------------------------------------------
    // boiler plate code copied from GFG
    static Node buildTree(String str){
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	        String s = br.readLine();
    	    Node root = buildTree(s);
			ArrayList <Integer> res = bottomView(root);
			for (Integer num : res) System.out.print (num + " ");
		    System.out.println();
	}
}