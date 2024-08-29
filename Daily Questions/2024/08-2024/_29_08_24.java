/*
 *  Q) Find length of Loop
        Given the head of a linked list, determine whether the list contains a loop. If a loop is present, return the number of nodes in the loop, otherwise return 0.
        Note: 'c' is the position of the node which is the next pointer of the last node of the linkedlist. If c is 0, then there is no loop.

    Example : 1
        Input: LinkedList: 25->14->19->33->10->21->39->90->58->45, c = 4
        Output: 7
        Explanation: The loop is from 33 to 45. So length of loop is 33->10->21->39-> 90->58->45 = 7. 
        The number 33 is connected to the last node of the linkedlist to form the loop because according to the input the 4th node from the beginning(1 based indexing) 
        will be connected to the last node for the loop.
    
    Example : 2
        Input: LinkedList: 5->4, c = 0
        Output: 0
        Explanation: There is no loop.

    Expected Time Complexity: O(n)
    Expected Auxiliary Space: O(1)

    Constraints:
        1 <= no. of nodes <= 10^6
        0 <= node.data <=10^6
        0 <= c<= n-1
 */

import java.io.*;
import java.util.*;

class Node {

  int data;
  Node next;

  Node(int x) {
    data = x;
    next = null;
  }
}

public class _29_08_24 {

  public static void printList(Node node) {
    while (node != null) {
      System.out.print(node.data + " ");
      node = node.next;
    }
    System.out.println();
  }

  public static void makeLoop(Node head, Node tail, int x) {
    if (x == 0) return;

    Node curr = head;
    for (int i = 1; i < x; i++) curr = curr.next;

    tail.next = curr;
  }

  public static int countLoopLength(Node loopNode) {
    int count = 1;
    Node temp = loopNode;
    while (temp.next != loopNode) {
      count++;
      temp = temp.next;
    }

    return count;
  }

  public static int countNodesinLoop(Node head) {
    // Add your code here.
    Node slow = head;
    Node fast = head;

    // Detecting loop using Floyd's Cycle-Finding Algorithm
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      // If slow and fast meet, there is a loop
      if (slow == fast) {
        return countLoopLength(slow);
      }
    }
    return 0;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ArrayList<Integer> arr = new ArrayList<>();

    System.out.print("Enter the linked list elemets seperated by spaces : ");
    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input);
    while (st.hasMoreTokens()) {
      arr.add(Integer.parseInt(st.nextToken()));
    }
    int k = Integer.parseInt(br.readLine());
    Node head = new Node(arr.get(0));
    Node tail = head;
    for (int i = 1; i < arr.size(); ++i) {
      tail.next = new Node(arr.get(i));
      tail = tail.next;
    }
    makeLoop(head, tail, k);

    System.out.println(countNodesinLoop(head));
  }
}
