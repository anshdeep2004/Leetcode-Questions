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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> check = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        check.offer(root);

        while(!check.isEmpty()) {
            int levelSize = check.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                if(check.peek().left != null) check.offer(check.peek().left);
                if(check.peek().right != null) check.offer(check.peek().right);
                res.add(check.poll().val);
            }
            result.add(res);
        }
        return result;
    }
}