/*
 *  Q) Left View of Binary Tree
        Difficulty: EasyAccuracy: 33.74%Submissions: 508K+Points: 2
        Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the function leftView(), which accepts root of the tree as argument. If no left view is possible, return an empty tree.
        Left view of following tree is 1 2 4 8.

                1
              /  \
             2     3
            / \   / \
           4   5 6   7
            \
             8   

    Example : 1
        Input:
                    1
                   /  \
                  3    2
        Output: 1 3

    Example : 2
        Input:
                10
               /  \
             20    30
            /  \
          40    60

        Output: 10 20 40
        
    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(N).

    Constraints:
        0 <= Number of nodes <= 10^5
        0 <= Data of a node <= 10^5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


// Boiler plate code of the GFG question....

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class _23_08_24 {
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
    

    // My logic will written in below function

    public static  ArrayList<Integer> leftView(Node root) {
      ArrayList<Integer> list=new ArrayList<>();
      helper(root,1,list);
      return list;
    }
    
    private static void helper(Node root,int level,ArrayList<Integer> list){
        if(root == null){
            return;
        }
        if(level > list.size())  
            list.add(root.data);
        helper(root.left,level+1,list);
        helper(root.right,level+1,list);
    }
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
            System.out.print("Enter tree nodes in single line using spaces :");
	        String s = br.readLine();
    	    Node root = buildTree(s);
    		ArrayList<Integer> result = leftView(root);
    		for(int value : result){
    			System.out.print(value + " ");
    		}
    		System.out.println();
    }
}