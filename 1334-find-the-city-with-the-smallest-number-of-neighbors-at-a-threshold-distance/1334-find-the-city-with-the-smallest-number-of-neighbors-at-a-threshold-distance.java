class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) graph[i][j] = 0;
                else graph[i][j] = (int) 1e9;
            }
        }

        for(int i=0; i<edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        
        for(int via=0; via<n; via++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    graph[i][j] = Math.min(graph[i][j], (graph[i][via] + graph[via][j]));
                }
            }
        }
        int countMin = Integer.MAX_VALUE;
        int node = -1;
        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<n; j++) {
                if(graph[i][j] <= distanceThreshold) count++;
            }
            if(count <= countMin) {
                countMin = count;
                node = i;
            }
        }
        return node;
    }
}