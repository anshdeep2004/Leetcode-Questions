class Solution {
    private boolean dfs(int i, int[] vis, int[] pathVis, int[][] graph, int[] check) {
        vis[i] = 1;
        pathVis[i] = 1;
        check[i] = 0;
        for(int node : graph[i]) {
            if(vis[node] == 0) {
                if(dfs(node, vis, pathVis, graph, check) == true) return true;
            }
            else if(pathVis[node] == 1) {
                return true;
            }
            else {
                // do nothing
            }
        }
        check[i] = 1;
        pathVis[i] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                dfs(i, vis, pathVis, graph, check);
            }
        }
        for(int i=0; i<n; i++) {
            if(check[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}