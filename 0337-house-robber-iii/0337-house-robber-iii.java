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


// Recussion
// class Solution {
//     public int robMoney(TreeNode node, int parentTaken) {
//         if(node == null) return 0;

//         // case 1: take
//         int take = 0;
//         if(parentTaken != 1) {
//             take = node.val + robMoney(node.left, 1) + robMoney(node.right, 1);
//         }

//         // case 2: not taken
//         int notTake = robMoney(node.left, 0) + robMoney(node.right, 0);

//         return Math.max(take, notTake);
//     }
//     public int rob(TreeNode root) {
//         return robMoney(root, 0);
//     }
// }


 // Memoization
// class Solution {
//     public int robMoney(TreeNode node, int parentTaken, HashMap<TreeNode, Integer> ptHash, HashMap<TreeNode, Integer> pntHash) {
//         if(node == null) return 0;

//         if(parentTaken == 0 && pntHash.get(node) != null) return pntHash.get(node);
//         else if(parentTaken == 1 && ptHash.get(node) != null) return ptHash.get(node);

//         // case 1: take
//         int take = 0;
//         if(parentTaken != 1) {
//             take = node.val + robMoney(node.left, 1, ptHash, pntHash) + robMoney(node.right, 1, ptHash, pntHash);
//         }

//         // case 2: not taken
//         int notTake = robMoney(node.left, 0, ptHash, pntHash) + robMoney(node.right, 0, ptHash, pntHash);

//         int res = Math.max(take, notTake);
//         if(parentTaken == 1) {
//             ptHash.put(node, res);
//         }
//         else if(parentTaken == 0) {
//             pntHash.put(node, res);
//         }

//         return res;
//     }
//     public int rob(TreeNode root) {
//         HashMap<TreeNode, Integer> ptHash = new HashMap<>();
//         HashMap<TreeNode, Integer> pntHash = new HashMap<>();
//         return robMoney(root, 0, ptHash, pntHash);
//     }
// }


// more better dfs approach using bottom up. The above approach is also correct but it is top down as we were checking for the parent if it is taken or not. In below approach we are considering the parent on the basis of children are taken or not. Just go throygh the solution once and you will understand that what is happening exactly.
class Solution {
    public int[] robMoneyDFS(TreeNode node) {
        if(node == null) return new int[] {0, 0};

        int[] left = robMoneyDFS(node.left);
        int[] right = robMoneyDFS(node.right);

        int[] res = new int[2];

        // case 1: take
        res[1] = node.val + left[0] + right[0];

        // case 2: not take
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return res;
    }

    public int rob(TreeNode root) {
        int[] ans = robMoneyDFS(root);
        return Math.max(ans[0], ans[1]);
    }
}