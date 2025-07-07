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
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        int maxSum = findMaxSum(root, sum);
        return sum[0];
    }
    public int findMaxSum(TreeNode node, int[] sum) {
        if(node == null) {
            return 0;
        }

        int leftSum = findMaxSum(node.left, sum);
        int rightSum = findMaxSum(node.right, sum);

        sum[0] = Math.max(sum[0], (leftSum + rightSum + node.val));

        return node.val + Math.max(leftSum, rightSum);
    }
}