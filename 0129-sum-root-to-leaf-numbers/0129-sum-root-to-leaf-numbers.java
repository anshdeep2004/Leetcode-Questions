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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        rootToLeafSum(root, 0);
        return sum;
    }

    public void rootToLeafSum(TreeNode node, int pathSum) {
        if(node == null) return ;
        
        pathSum = pathSum * 10 + node.val;

        if(node.left == null && node.right == null) {
            sum += pathSum;
        }

        rootToLeafSum(node.left, pathSum);
        rootToLeafSum(node.right, pathSum);
    }
}