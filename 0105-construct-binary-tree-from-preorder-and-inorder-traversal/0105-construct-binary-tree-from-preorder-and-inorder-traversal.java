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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = makeTree(preorder, inorder, 0, (preorder.length - 1), 0, (inorder.length - 1), map);
        return root;
    }
    public TreeNode makeTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int rootIndex = map.get(root.val);
        int leftNodes = rootIndex - inStart;

        root.left = makeTree(preorder, inorder, preStart + 1, preStart + leftNodes, inStart, rootIndex - 1, map);
        root.right = makeTree(preorder, inorder, preStart + leftNodes + 1, preEnd, rootIndex + 1, inEnd, map);
        return root;
    }
}