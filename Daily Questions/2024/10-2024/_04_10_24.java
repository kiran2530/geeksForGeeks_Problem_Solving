/*
 *  Q) Deletion and Reverse in Circular Linked List
        Given a Circular Linked List. The task is to delete the given node, key in the circular linked list, and reverse the circular linked list.

        Note:
        You don't have to print anything, just return the head of the modified list in each function.
        Nodes may consist of Duplicate values.
        The key may or may not be present.
        
    Examples:
        Input: Linked List: 2->5->7->8->10, key = 8
        Output: 10->7->5->2 
        Explanation: After deleting 8 from the given circular linked list, it has elements as 2, 5, 7, 10. Now, reversing this list will result in 10, 7, 5, 2 & the resultant list is also circular.
        
        Input: Linked List: 1->7->8->10, key = 8
        Output: 10->7->1
        Explanation: After deleting 8 from the given circular linked list, it has elements as 1, 7,10. Now, reversing this list will result in 10, 7, 1 & the resultant list is also circular.
        
        Input: Linked List: 3->6->4->10, key = 9
        Output: 10->4->6->3
        Explanation: As there no key present in the list, so simply reverse the list & the resultant list is also circular.
        
    Expected Time Complexity: O(n)
    Expected Auxillary Space: O(1)

    Constraints:
        2 <= number of nodes, key  <= 10^5
        1 <= node -> data <= 10^5
 */


class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
public class _04_10_24 {
    Node reverse(Node head) {
        // code here
       
        Node temp = head;
        Node prev = null;
        Node tail = head;
        boolean iterate=true;
        while (temp != head||iterate) {
            iterate=false;
            Node t = temp.next;
            temp.next = prev;
            prev = temp;
            temp = t;
        }
        tail.next = prev;
        return prev;
        
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
        if (head.data == key) {
            Node temp = head.next;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            return head.next;
        }
        Node temp = head.next;
        Node prev = head;
        while (temp != head) {
            if (temp.data == key) {
                prev.next = temp.next;
                if (temp == head.next) {
                    head.next = temp.next;
                }
                return head;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}
