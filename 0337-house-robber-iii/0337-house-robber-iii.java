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
    public int robMoney(TreeNode node, int parentTaken, HashMap<TreeNode, Integer> ptHash, HashMap<TreeNode, Integer> pntHash) {
        if(node == null) return 0;

        if(parentTaken == 0 && pntHash.get(node) != null) return pntHash.get(node);
        else if(parentTaken == 1 && ptHash.get(node) != null) return ptHash.get(node);

        // case 1: take
        int take = 0;
        if(parentTaken != 1) {
            take = node.val + robMoney(node.left, 1, ptHash, pntHash) + robMoney(node.right, 1, ptHash, pntHash);
        }

        // case 2: not taken
        int notTake = robMoney(node.left, 0, ptHash, pntHash) + robMoney(node.right, 0, ptHash, pntHash);

        int res = Math.max(take, notTake);
        if(parentTaken == 1) {
            ptHash.put(node, res);
        }
        else if(parentTaken == 0) {
            pntHash.put(node, res);
        }

        return res;
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> ptHash = new HashMap<>();
        HashMap<TreeNode, Integer> pntHash = new HashMap<>();
        return robMoney(root, 0, ptHash, pntHash);
    }
}