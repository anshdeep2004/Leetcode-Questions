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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = head;
        swapWhole(head.next, head);

        return temp;
    }

    public void swapWhole(ListNode node, ListNode prevNode) {
        if(node == null || node.next == null) return ;
        ListNode temp = node.next;
        node.next = temp.next;
        temp.next = node;
        prevNode.next = temp;

        swapWhole(node.next, node);
    }
}