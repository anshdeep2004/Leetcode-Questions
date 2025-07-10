/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();

        findPath(root, pPath, p);
        findPath(root, qPath, q);

        int i = 0;
        int size = qPath.size() < pPath.size() ? qPath.size() : pPath.size();
        while(i < size) {
            if(pPath.get(i) != qPath.get(i)) {
                return pPath.get(i-1);
            }
            i++;
        }
        return pPath.get(i-1);
    }

    public boolean findPath(TreeNode node, List<TreeNode> path, TreeNode check) {
        if(node == null) {
            return false;
        }
        path.add(node);
        if(node.val == check.val) {
            return true;
        }

        if(findPath(node.left, path, check) || findPath(node.right, path, check)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
}