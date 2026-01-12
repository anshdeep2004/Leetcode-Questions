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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        int[] freq = new int[301];
        ListNode check = null;

        while(temp != null) {
            freq[temp.val] += 1;
            temp = temp.next; 
        }

        temp = head;
        while(temp != null) {
            if(freq[temp.val] == 1) {
                if(check == null) {
                    check = temp;
                    head = temp;
                }
                else {
                    check.next = temp;
                    check = check.next;
                }
            }
            temp = temp.next;
        }
        if(check == null) return null;
        check.next = null;

        return head;
    }
}