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
    public boolean isValid(int adjRow, int adjCol, int n) {
        return adjRow >= 0 && adjRow < n && adjCol >= 0 && adjCol < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] row = new int[] {1, 0, -1, 0};
        int[] col = new int[] {0, 1, 0, -1};
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    for(int k=0; k<4; k++) {
                        int adjRow = i + row[k];
                        int adjCol = j + col[k];
                        if(isValid(adjRow, adjCol, n) && grid[adjRow][adjCol] == 1) {
                            int node = i * n + j;
                            int adjNode = adjRow * n + adjCol;
                            ds.unionBySize(adjNode, node);
                        }
                    }
                }
            }
        }
        int maxSizeIsland = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    for(int k=0; k<4; k++) {
                        int adjRow = i + row[k];
                        int adjCol = j + col[k];
                        if(isValid(adjRow, adjCol, n) && grid[adjRow][adjCol] == 1) {
                            int adjNode = adjRow * n + adjCol;
                            int ulp_adjNode = ds.findParent(adjNode);
                            set.add(ulp_adjNode);
                        }
                    }
                    int localMax = 0;
                    for(int node : set) {
                        localMax += ds.size.get(node);
                    }
                    maxSizeIsland = Math.max(maxSizeIsland, localMax + 1);
                }
            }
        }
        for(int node=0; node<n*n; node++) {
            maxSizeIsland = Math.max(maxSizeIsland, ds.size.get(ds.findParent(node)));
        }
        return maxSizeIsland;
    }
}