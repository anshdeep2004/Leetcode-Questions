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
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = makeBST(preorder, 0, preorder.length-1);
        return root;
    }
    public TreeNode makeBST(int[] preorder, int preStart, int preEnd) {
        if(preStart > preEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int i = preStart + 1;
        while(i <= preEnd && preorder[i] < root.val) i++;

        root.left = makeBST(preorder, preStart + 1, i - 1);
        root.right = makeBST(preorder, i, preEnd);

        return root;
    }
}