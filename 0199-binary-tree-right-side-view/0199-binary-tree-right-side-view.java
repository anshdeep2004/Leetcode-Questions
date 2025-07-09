class Solution {
    class Pair {
        TreeNode node;
        int num;
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Queue<Pair> que = new LinkedList<Pair>();
        if(root == null) return result;
        que.offer(new Pair(root, 0));
        while(!que.isEmpty()) {
            Pair temp = que.poll();
            TreeNode tNode = temp.node;
            int n = temp.num;
            if(map.get(n) == null) map.put(n, tNode);
            if(tNode.right != null) {
                que.offer(new Pair(tNode.right, (n + 1)));
            }
            if(tNode.left != null) {
                que.offer(new Pair(tNode.left, (n + 1)));
            }
        }
        for(Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
            result.add(entry.getValue().val);
        }
        return result;
    }
}