package leetcode;

import java.io.*;
import java.util.*;
// import stat ;
//Complexity: T:O(M,N), S: O(1)
class _2_AddTwoNumber {

  public static void main(String[] args) {
    System.out.println("test");
  }
  
  public static ListNode AddTwoNumber(ListNode p1, ListNode p2){
    ListNode l1 = p1;
    ListNode l2 = p2;
    ListNode newHead = new ListNode(0);
    ListNode current = newHead;
    int carry = 0; //initia is 0
    while(l1 != null || l2 != null) {
      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;
      int oneDigitSum = carry + l1Val + l2Val;
      current.next = new ListNode(oneDigitSum %10);
      //dont forget to update the position
      current = current.next;
      // current.next = new ListNode(oneDigitSum); // You can't store a number more than 9 in a single node.
      carry = oneDigitSum / 10;
      if(l1 != null){
       l1 = l1.next; 
      }
      if(l2 != null){
        l2 = l2.next; 
       }
      // l1 = l1.next; // nullpointerexception
      // l2 = l2.next; // nullpointerException
    }
    // check if carry > 0 when out of the loop process.
    if(carry > 0){
      current.next = new ListNode(carry);
    }
    return newHead.next;
  }

}