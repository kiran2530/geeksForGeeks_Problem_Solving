/*
 *  Q) Rotate a Linked List
        Given the head of a singly linked list, the task is to rotate the linked list anti-clockwise by k nodes, i.e., left-shift the linked list by k nodes, where k is a given positive integer smaller than or equal to length of the linked list.

    Example : 1
        Input: linkedlist: 2->4->7->8->9 , k = 3
        Output: 8->9->2->4->7
        Explanation:
        Rotate 1: 4 -> 7 -> 8 -> 9 -> 2
        Rotate 2: 7 -> 8 -> 9 -> 2 -> 4
        Rotate 3: 8 -> 9 -> 2 -> 4 -> 7

    Example : 1
        Input: linkedlist: 1->2->3->4->5->6->7->8 , k = 4
        Output: 5->6->7->8->1->2->3->4

    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 <= number of nodes <= 103
        1 <= node -> data <= 104
        1 <= k <= number of nodes 
 */

public class _10_08_24 {
    class Node {
        int data;
        Node next;
    
        Node(int x) {
            data = x;
            next = null;
        }
    }


    static Node head, end;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            end = head;
            return;
        }

        end.next = newNode;
        end = newNode;
    }

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static Node rotate(Node head, int k) {
        // add code here

        Node start = head, last = null;
        int length = 1;

        while (start.next != null) {
            length++;
            last = start.next;
            start = start.next;
        }

        k = k % length;

        while (k != 0) {
            start = head;
            head = head.next;
            last.next = start;
            start.next = null;
            last = start;
            k--;
        }

        return head;
    }
    public static void main(String[] args) {
        _10_08_24 linkedList = new _10_08_24();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);
        linkedList.insert(4);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(7);
        linkedList.insert(8);

        int k = 4;
        head = rotate(head, k);

        linkedList.printList();
    }
}