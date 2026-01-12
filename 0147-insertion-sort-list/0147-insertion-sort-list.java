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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = head.next;
        ListNode sortedStart = head;
        ListNode sortedEnd = head;

        while(temp != null) {
            if(temp.val < sortedStart.val) {
                sortedEnd.next = temp.next;
                temp.next = sortedStart;
                sortedStart = temp;
                temp = sortedEnd.next;
            }
            else {
                ListNode sorted = sortedStart;
                while(sorted.next != sortedEnd.next && sorted.next.val < temp.val) {
                    sorted = sorted.next;
                }
                if(sorted.next == sortedEnd.next) {
                    sortedEnd = temp;
                    temp = temp.next;
                }
                else {
                    sortedEnd.next = temp.next;
                    temp.next = sorted.next;
                    sorted.next = temp;
                    temp = sortedEnd.next;
                }
            }
        }

        return sortedStart;
    }
}