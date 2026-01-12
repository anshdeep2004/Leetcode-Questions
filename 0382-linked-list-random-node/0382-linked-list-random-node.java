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
    ListNode head;
    int listLen;
    public Solution(ListNode head) {
        this.head = head;
        ListNode temp = head;
        while(temp != null) {
            this.listLen++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        Random rand = new Random();
        int randNum = rand.nextInt(listLen);
        ListNode temp = this.head;
        for(int i=0; i<randNum; i++) {
            temp = temp.next;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */