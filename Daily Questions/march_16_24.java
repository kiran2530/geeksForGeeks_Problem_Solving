/**
 * Q) 16-03-2024 : Delete without head pointer
    You are given a node del_node of a Singly Linked List where you have to delete a value of the given node from the linked list but you are not given the head of the list. By deleting the node value, we do not mean removing it from memory. 
    We mean:
        The value of the given node should not exist in the linked list.
        The number of nodes in the linked list should decrease by one.
        All the values before & after the del_node node should be in the same order.
    
    Note: Multiple nodes can have the same values as the del_node, but you must only remove the node whose pointer del_node is given to you. It is guaranteed that there exists a node with a value equal to the del_node value and it will not be the last node of the linked list.
    
    Example 1:
    Input:
    Linked List = 1 -> 2
    del_node = 1
    Output: 2
    Explanation: 
    After deleting 1 from the linked list, we have remaining nodes as 2.
    
    Example 2:
    Input:
    Linked List = 10 -> 20 -> 4 -> 30
    del_node = 20
    Output: 10 4 30
    Explanation: 
    After deleting 20 from the linked list, we have remaining nodes as 10, 4, 30.
    
    Your Task:
    You don't need to read or print anything. You only need to complete the function deleteNode() which takes a reference of the deleting node value & your task is to delete the given node value.

    Expected Time Complexity: O(1).
    Expected Auxilliary Space: O(1).

    Constraints:
        2 <= n <= 10^3  
        1 <= elements of the linked list <= 10^9
 */
public class march_16_24 {
    class Node {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    public Node head = null, tail = null;

    public void addNode(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void diplay(Node newNode) {
        Node node = newNode;
        if(head == null) {
            System.out.println("list empty...");
            return;
        }

        while (node != null) {
            System.out.print(node.data +  " ");
            node = node.next;            
        }
    }
    public Node getNode() {
        return head;
    }
    public static void deleteNode(Node del_node) {
         del_node.data = del_node.next.data;
         del_node.next = del_node.next.next;
    }

    public static void main(String[] args) {
        march_16_24 node = new march_16_24();
        node.addNode(10);
        node.addNode(20);
        node.addNode(4);
        node.addNode(30);

        Node head = node.getNode();
        System.out.print(" Full List : ");
        node.diplay(head);
        System.out.println();

        System.out.print(" After Deleting Node : ");
        Node del_node = head.next;
        deleteNode(del_node);
        node.diplay(head);
    }
}