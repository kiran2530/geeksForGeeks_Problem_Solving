/*
 *  Q) Palindrome Linked List
        Given a singly linked list of integers. The task is to check if the given linked list is palindrome or not.

    Example : 1
        Input: LinkedList: 1->2->1->1->2->1
        Output: true
        Explanation: The given linked list is 1->2->1->1->2->1 , which is a palindrome and Hence, the output is true.

    Example : 2
        Input: LinkedList: 1->2->3->4
        Output: false
        Explanation: The given linked list is 1->2->3->4, which is not a palindrome and Hence, the output is false.

    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1) 

    Note: You should not use the recursive stack space as well

    Constraints:
        1 <= number of nodes <= 10^5
        1 ≤ node->data ≤ 10^3
 */

import java.io.*;
import java.util.ArrayList;

class Node {

  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class _25_09_24 {

  static Node insert(Node head, int data) {
    Node temp = new Node(data);
    if (head == null) {
      head = temp;
      return head;
    } else {
      Node t = head;
      while (t.next != null) {
        t = t.next;
      }
      t.next = temp;
    }
    return head;
  }

  static void printList(Node head) {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Node head = null;

    String str[] = read.readLine().trim().split(" ");
    int listSize = str.length;
    for (int i = 0; i < listSize; i++) {
      head = insert(head, Integer.parseInt(str[i]));
    }
    boolean f = new Solution().isPalindrome(head);

    System.out.println(f ? "true" : "false");
  }
}

class Solution {

  // Function to check whether the list is palindrome.
  boolean isPalindrome(Node head) {
    // Your code here
    ArrayList<Integer> list = new ArrayList<>();

    while (head != null) {
        list.add(head.data);
        head = head.next;
    }

    int i = 0, j = list.size()-1;
    while (i<j) {
        if(!list.get(i).equals(list.get(j)))
            return false;
        i++;
        j--;
    }

    return true;
  }
}
