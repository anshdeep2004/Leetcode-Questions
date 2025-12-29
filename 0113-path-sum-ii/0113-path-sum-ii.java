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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        allPathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public void allPathSum(TreeNode node, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if(node == null) return ;

        targetSum -= node.val;
        temp.add(node.val);
        if(node.left == null && node.right == null) {
            if(targetSum == 0) {
                List<Integer> arr = new ArrayList<>(temp);
                result.add(arr);
            }
        }
        else {
            allPathSum(node.left, targetSum, result, temp);
            allPathSum(node.right, targetSum, result, temp);
        }
        
        temp.remove(temp.size() - 1);
    }
}