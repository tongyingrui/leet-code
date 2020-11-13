package tyr.leet.code;

import tyr.leet.code.data.structures.ListNode;

public class Solution328 {

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */
  class Solution {
    public ListNode oddEvenList(ListNode head) {
      if (head == null) return null;
      ListNode split = head;

      ListNode prev = head;
      ListNode iter = head.next;

      int index = 0;
      while (iter != null) {
        // if (iter.val % 2 == split.val % 2) {
        if (index++ % 2 != 0) {
          prev.next = iter.next;
          iter.next = split.next;
          split.next = iter;
          split = iter;
          iter = prev.next;
        } else {
          prev = iter;
          iter = iter.next;
        }
      }
      return head;
    }
  }
}
