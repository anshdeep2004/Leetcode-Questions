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
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         List<Integer> arr = new ArrayList<>();
//         TreeNode curr = root;
//         while(curr != null) {
//             if(curr.left == null) {
//                 arr.add(curr.val);
//                 curr = curr.right;
//             }
//             else {
//                 TreeNode temp = curr.left;
//                 while(temp.right != null && temp.right != curr) {
//                     temp = temp.right;
//                 }
//                 if(temp.right == null) {
//                     temp.right = curr;
//                     curr = curr.left;
//                 }
//                 else {
//                     temp.right = null;
//                     arr.add(curr.val);
//                     curr = curr.right;
//                 }
//             }
//         }
//         int n = arr.size();
//         for(int i=0; i<n-1; i++) {
//             if(arr.get(i) >= arr.get(i+1)) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }

// The above code is good to go as we are using an inorder traversal to go through the tree to and then check if the inorder traversal is in acsending order. But its takes O(N) time complexity everytime. The below code is not taking time O(N) everytime as it is traversing and as soon as a unwanted node is found then it returns true. The idea is to carry the range for every Node and check if the node liye in that range.

class Solution {
    public boolean isValidBST(TreeNode root) {
        return checkRangeInBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    public boolean checkRangeInBST(TreeNode root, int maxVal, int minVal) {
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        return checkRangeInBST(root.left, root.val, minVal) && checkRangeInBST(root.right, maxVal, root.val);
    }
}