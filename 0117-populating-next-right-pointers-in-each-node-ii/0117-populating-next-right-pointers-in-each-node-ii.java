/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()) {
            List<Node> arr = new ArrayList<>();
            int size = que.size();
            for(int i=0; i<size; i++) {
                Node node = que.poll();
                arr.add(node);
            }

            for(Node node : arr) {
                if(node != null && node.left != null) que.offer(node.left);
                if( node != null && node.right != null) que.offer(node.right);
            }

            for(int i=0; i<arr.size()-1; i++) {
                arr.get(i).next = arr.get(i+1);
            }
        }

        return root;
    }
}