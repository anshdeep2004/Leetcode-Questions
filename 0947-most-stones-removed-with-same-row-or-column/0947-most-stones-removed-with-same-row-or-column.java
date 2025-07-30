class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    DisjointSet(int n) {
        for(int i=0; i<n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findParent(int node) {
        if(node == parent.get(node)) return node;
        int ulp = findParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if(ulp_u == ulp_v) return ;
        else if(size.get(ulp_u) > size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
        else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }
    }
}
class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        int components = 0;
        for(int i=0; i<stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for(int i=0; i<stones.length; i++) {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + maxRow + 1;
            ds.unionBySize(rowNode, colNode);
            stoneNodes.put(rowNode, 1);
            stoneNodes.put(colNode, 1);
        }
        for(Map.Entry<Integer, Integer> map : stoneNodes.entrySet()) {
            if(ds.findParent(map.getKey()) == map.getKey()) components++;
        }
        return stones.length - components;
    }
}