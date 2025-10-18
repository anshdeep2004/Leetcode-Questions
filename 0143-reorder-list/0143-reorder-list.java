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
    public void reorderList(ListNode head) {
        if(head.next == null) return ;
        ListNode tail = null;
        ListNode temp = head;

        List<ListNode> nodes = new ArrayList<>();
        while(temp != null) {
            nodes.add(temp);
            temp = temp.next;
        }

        tail = nodes.get(nodes.size() - 1);

        reList(head, tail, nodes);
    }

    public void reList(ListNode head, ListNode tail, List<ListNode> nodes) {
        if(head == tail || head.next == tail) return ;

        nodes.remove(nodes.size() - 1);
        ListNode newHead = head.next;
        ListNode newTail = nodes.get(nodes.size() - 1);

        head.next = tail;
        tail.next = newHead;
        newTail.next = null;

        reList(newHead, newTail, nodes);
    }
}