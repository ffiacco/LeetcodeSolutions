//Given a linked list, remove the n-th node from the end of list and return its head.

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fastRunner = head, slowRunner = null, prev = head;
        int index = 1;
        
        while (fastRunner != null){
            if (index == n){
                slowRunner = head;
            }
            else if (slowRunner != null){
                prev = slowRunner;
                slowRunner = slowRunner.next;
            }
            fastRunner = fastRunner.next;  
            index++;
        }
        
        if (slowRunner == head)
            head = slowRunner.next;
        else
            prev.next = slowRunner.next;
        
        return head;
    }
}