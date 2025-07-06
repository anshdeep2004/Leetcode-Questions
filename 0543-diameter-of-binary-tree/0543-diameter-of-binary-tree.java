class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int [] diameter = new int[1];
        findDiameter(root, diameter);
        return diameter[0];
    }
    public int findDiameter(TreeNode node, int[] diameter) {
        if(node == null) {
            return 0;
        }
        int lh = findDiameter(node.left, diameter);
        int rh = findDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], (lh + rh));

        return 1 + Math.max(lh, rh);
    }
}