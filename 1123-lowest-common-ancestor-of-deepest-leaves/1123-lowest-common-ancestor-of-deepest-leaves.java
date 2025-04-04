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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = maxTreeDepth(root);
        return dfs(root, maxDepth, 0);
    }

    public int maxTreeDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(maxTreeDepth(node.left), maxTreeDepth(node.right));
    }

    public TreeNode dfs(TreeNode node, int max, int len) {
        if(node == null) {
            return null;
        }
        if(max - 1 == len) {
            return node;
        }
        TreeNode left = dfs(node.left, max, len + 1);
        TreeNode right = dfs(node.right, max, len + 1);

        if(left != null && right != null) {
            return node;
        }
        else {
            return left == null ? right : left;
        }
    }
}