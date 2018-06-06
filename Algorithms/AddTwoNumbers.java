/**
 *You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode iterator1 = l1;
        ListNode iterator2 = l2;
        ListNode result = new ListNode(0);
        ListNode resultIterator = result;
        int riporto = 0;
        
        while (iterator1 != null || iterator2 != null || riporto > 0){
            int res = ((iterator1 != null) ? iterator1.val : 0) + ((iterator2 != null) ? iterator2.val : 0) + riporto;
            if (res >= 10){
                res -=10;
                riporto = 1;
            } else {
                riporto = 0;
            }
            resultIterator.val = res;
            if (iterator1 != null && iterator1.next != null){
                resultIterator.next = new ListNode(0);
                resultIterator = resultIterator.next;
            } else if (iterator2 != null && iterator2.next != null){
                resultIterator.next = new ListNode(0);
                resultIterator = resultIterator.next;
            } else if (riporto > 0){
                resultIterator.next = new ListNode(0);
                resultIterator = resultIterator.next;
            }
            
            
            iterator1 = (iterator1 != null) ? iterator1.next : null;
            iterator2 = (iterator2 != null) ? iterator2.next : null;
        }
        
        return result;
    }
}