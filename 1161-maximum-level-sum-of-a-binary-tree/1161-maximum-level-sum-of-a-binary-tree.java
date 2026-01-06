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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        que.offer(root);
        int maxSum = root.val;
        int maxSumLevel = 1;
        int i = 1;

        while(!que.isEmpty()) {
            int tempSum = 0;
            int currSize = que.size();
            int flag = 0;
            for(int j=0; j<currSize; j++) {
                TreeNode temp = que.poll();
                // System.out.print(temp.val + " : ");
                if(temp.left != null) {
                    que.offer(temp.left);
                    tempSum += temp.left.val;
                    flag = 1;
                    // System.out.print(temp.left.val + ", ");
                }
                if(temp.right != null) {
                    que.offer(temp.right);
                    tempSum += temp.right.val;
                    flag = 1;
                    // System.out.println(temp.right.val);
                }
            }
            i++;
            if(maxSum < tempSum && flag == 1) {
                maxSum = tempSum;
                maxSumLevel = i;
            }
            System.out.println(maxSum + " " + maxSumLevel);
        }

        return maxSumLevel;
    }
}