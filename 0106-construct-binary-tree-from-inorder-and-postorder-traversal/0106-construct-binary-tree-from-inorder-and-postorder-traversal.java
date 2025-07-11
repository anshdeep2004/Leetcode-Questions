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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = makeTree(postorder, inorder, 0, (postorder.length - 1), 0, (inorder.length - 1), map);
        return root;
    }
    public TreeNode makeTree(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(postStart > postEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.val);
        int leftNodes = rootIndex - inStart;

        root.left = makeTree(postorder, inorder, postStart, postStart + leftNodes - 1, inStart, rootIndex - 1, map);
        root.right = makeTree(postorder, inorder, postStart + leftNodes, postEnd - 1, rootIndex + 1, inEnd, map);
        return root;
    }
}