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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;
        que.offer(root);

        while(!que.isEmpty()) {
            int levelSize = que.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                if(que.peek().left != null) que.offer(que.peek().left);
                if(que.peek().right != null) que.offer(que.peek().right);
                res.add(que.poll().val);
            }
            result.add(res);
        }
        Collections.reverse(result);
        return result;
    }
}