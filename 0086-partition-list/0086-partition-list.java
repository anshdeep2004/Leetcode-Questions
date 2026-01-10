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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode greaterThanX = null;
        ListNode greater = greaterThanX;
        ListNode smallerThanX = null;
        ListNode smaller = smallerThanX;

        while(temp != null) {
            if(temp.val >= x) {
                if(greater == null) {
                    greaterThanX = new ListNode(temp.val);
                    greater = greaterThanX;
                }
                else {
                    greater.next = new ListNode(temp.val);
                    greater = greater.next;
                }
            }
            else {
                if(smallerThanX == null) {
                    smallerThanX = new ListNode(temp.val);
                    smaller = smallerThanX;
                }
                else {
                    smaller.next = new ListNode(temp.val);
                    smaller = smaller.next;
                }
            }
            temp = temp.next;
        }
        if(smallerThanX == null) {
            return greaterThanX;
        }
        
        smaller.next = greaterThanX;
        return smallerThanX;
    }
}