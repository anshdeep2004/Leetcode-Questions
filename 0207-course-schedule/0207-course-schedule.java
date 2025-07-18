class Solution {
    private boolean dfs(int i, int[] vis, List<List<Integer>> adj) {
        vis[i] = 2;
        for(int node : adj.get(i)) {
            if(vis[node] == 0) {
                if(dfs(node, vis, adj) == true) return true;
            }
            else if(vis[node] == 2) {
                return true;
            }
            else {
                // do nothing
            }
        }
        vis[i] = 1;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] vis = new int[numCourses];
        // Stack<Integer> st = new Stack<>();

        for(int i=0; i<numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0; i<numCourses; i++) {
            if(vis[i] == 0) {
                if(dfs(i, vis, graph) == true) return false;
            }
        }
        return true;
    }
}