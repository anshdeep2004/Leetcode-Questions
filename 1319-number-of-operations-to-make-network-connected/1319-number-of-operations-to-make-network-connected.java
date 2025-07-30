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
    public int makeConnected(int n, int[][] connections) {
        DisjointSet dis = new DisjointSet(n);
        int components = 0;
        int unUsedEdges = 0;
        for(int i=0; i<connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            if(dis.findParent(u) == dis.findParent(v)) unUsedEdges++;
            else dis.unionBySize(u, v);
        }
        for(int i=0; i<n; i++) {
            int parent = dis.findParent(i);
            if(parent == i) components++;
        }
        if(unUsedEdges >= (components - 1)) {
            return components - 1;
        }
        else {
            return -1;
        }
    }
}