class Pair {
    int dist;
    int[] pos;
    Pair(int dist, int[] pos) {
        this.dist = dist;
        this.pos = pos;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair> ((x, y) -> x.dist - y.dist);
        int[][] distance = new int[n][n];
        for(int k=0; k<n; k++) {
            for(int j=0; j<n; j++) {
                distance[k][j] = (int) 1e9;
            }
        }
        distance[0][0] = 1;
        pq.offer(new Pair(1, new int[] {0, 0}));
        int[] row = new int[] {0, 1, 0, -1, 1, -1, 1, -1};
        int[] col = new int[] {1, 0, -1, 0, 1, 1, -1, -1};
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int dist = p.dist;
            int[] nodePos = p.pos;
            for(int i=0; i<8; i++) {
                int x = nodePos[0] + row[i];
                int y = nodePos[1] + col[i];
                if(x >= 0  && x <n && y >= 0 && y < n && grid[x][y] == 0) {
                    if(dist + 1 < distance[x][y]) {
                        distance[x][y] = dist + 1;
                        pq.offer(new Pair(dist + 1, new int[] {x, y}));
                    }
                }
            }
        }
        if(distance[n-1][n-1] == (int) 1e9) {
            return -1;
        }
        else {
            return distance[n-1][n-1];
        }
    }
}