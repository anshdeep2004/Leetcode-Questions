class Solution {
    public void dfs(int i, int[] vis, List<List<Integer>> adj) {
        vis[i] = 1;
        for(int nebor : adj.get(i)) {
            if(vis[nebor] != 1) {
                dfs(nebor, vis, adj);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] vis = new int[isConnected.length];
        int count = 0;

        for(int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<isConnected.length; i++) {
            for(int j=0; j<isConnected.length; j++) {
                if(isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        for(int i=0; i<vis.length; i++) {
            if(vis[i] != 1) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;
    }
}