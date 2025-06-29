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
    public ListNode mergeKLists(ListNode[] lists) {
        // Base case
        if (lists == null || lists.length == 0) return null;

        // PriorityQueue to store nodes in ascending order of value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list to the heap (if not null)
        for (ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }

        // Dummy node to build the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // While the heap is not empty
        while (!pq.isEmpty()) {
            // Extract the smallest node
            ListNode node = pq.poll();
            current.next = node;      // Append it to the result
            current = current.next;   // Move the pointer

            // If the node has a next, add it to the heap
            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
