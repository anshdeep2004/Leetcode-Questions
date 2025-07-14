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
    public boolean isValidBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                arr.add(curr.val);
                curr = curr.right;
            }
            else {
                TreeNode temp = curr.left;
                while(temp.right != null && temp.right != curr) {
                    temp = temp.right;
                }
                if(temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                else {
                    temp.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        int n = arr.size();
        for(int i=0; i<n-1; i++) {
            if(arr.get(i) >= arr.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}