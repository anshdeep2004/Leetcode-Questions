class Solution {
    class Pair {
        int node;
        int color;
        Pair(int node, int color) {
            this.node = node;
            this.color = color;
        }
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];

        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                Queue<Pair> que = new LinkedList<>();
                que.offer(new Pair(i, 1));
                vis[i] = 1;
                while(!que.isEmpty()) {
                    Pair p = que.poll();
                    int node = p.node;
                    int color = p.color;
                    for(int v : graph[node]) {
                        if(vis[v] == 0) {
                            int c = color == 1 ? 2 : 1;
                            que.offer(new Pair(v, c));
                            vis[v] = c;
                        }
                        else if(vis[v] == vis[node]) {
                            return false;
                        }
                        else {
                            continue;
                        }
                    }
                }
            }
        }
        return true;
    }
}