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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode temp = root;
        TreeNode parent = null;

        // Step 1: Find the node to delete
        while (temp != null && temp.val != key) {
            parent = temp;
            temp = key < temp.val ? temp.left : temp.right;
        }

        if (temp == null) return root; // Key not found

        // Case 1: Node has right child (try inorder successor)
        if (temp.right != null) {
            TreeNode successor = temp.right;
            TreeNode succParent = temp;

            while (successor.left != null) {
                succParent = successor;
                successor = successor.left;
            }

            temp.val = successor.val; // Replace value

            // Remove successor node
            if (succParent == temp)
                succParent.right = successor.right;
            else
                succParent.left = successor.right;
        }

        // Case 2: No right child, but has left child (use predecessor)
        else if (temp.left != null) {
            TreeNode predecessor = temp.left;
            TreeNode predParent = temp;

            while (predecessor.right != null) {
                predParent = predecessor;
                predecessor = predecessor.right;
            }

            temp.val = predecessor.val;

            // Remove predecessor node
            if (predParent == temp)
                predParent.left = predecessor.left;
            else
                predParent.right = predecessor.left;
        }

        // Case 3: Leaf node (no children)
        else {
            if (parent == null) {
                return null; // Deleting root node which is a leaf
            }

            if (parent.left == temp)
                parent.left = null;
            else
                parent.right = null;
        }

        return root;
    }
}
