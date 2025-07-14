/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();

    boolean goBack;

    public BSTIterator(TreeNode root, boolean goBack) {
        this.goBack = goBack;
        pushAll(root);
    }
    
    public int nextBefore() {
        TreeNode temp = st.pop();
        if(goBack == true) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }
    
    public boolean hasNext() {
        return (!st.isEmpty());
    }

    public void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            if(goBack == true) node = node.right;
            else node = node.left;
        }
    }
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTIterator next = new BSTIterator(root, false);
        BSTIterator before = new BSTIterator(root, true);

        int i = next.nextBefore();
        int j = before.nextBefore();
        while(i < j) {
            if(i + j == k) return true;
            else if((i + j) < k) i = next.nextBefore();
            else j = before.nextBefore();
        }
        return false;
    }
}