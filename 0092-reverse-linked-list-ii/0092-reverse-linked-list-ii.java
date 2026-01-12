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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode beforeStart = null;
        ListNode afterEnd = null;
        ListNode start = null;
        ListNode end = null;
        ListNode temp = head;

        int i = 1;
        while(temp != null) {
            if(i == left - 1) {
                beforeStart = temp;
                start = temp.next;
            }
            if(i == left) {
                start = temp;
            }
            if(i == right) {
                end = temp;
                afterEnd = temp.next;
            }
            i++;
            temp = temp.next;
        }
        if(beforeStart != null) beforeStart.next = null;
        end.next = null;

        ListNode curr = start;
        ListNode prev = null;
        ListNode next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if(beforeStart != null) beforeStart.next = prev;
        else head = prev;

        if(start != null) start.next = afterEnd;

        return head;
    }
}