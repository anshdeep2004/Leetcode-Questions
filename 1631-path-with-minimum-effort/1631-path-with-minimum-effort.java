class Pair {
    int diffi;
    int[] pos;
    Pair(int diffi, int[] pos) {
        this.diffi = diffi;
        this.pos = pos;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair> ((x, y) -> x.diffi - y.diffi);
        int[][] diff = new int[n][m];

        for(int j=0; j<n; j++) {
            for(int k=0; k<m; k++) {
                diff[j][k] = (int) 1e9;
            }
        }

        diff[0][0] = 0;
        pq.offer(new Pair(0, new int[] {0, 0}));
        int[] row = new int[] {0, 1, 0, -1};
        int[] col = new int[] {1, 0, -1, 0};
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int diffi = p.diffi;
            int[] pos = p.pos;
            for(int i=0; i<4; i++) {
                int x = pos[0] + row[i];
                int y = pos[1] + col[i];
                if(x >= 0 && x < n && y >= 0 && y < m) {
                    int d = Math.max(diffi, Math.abs(heights[pos[0]][pos[1]] - heights[x][y]));
                    if(d < diff[x][y]) {
                        diff[x][y] = d;
                        pq.offer(new Pair(d, new int[] {x, y}));
                    }
                }
            }
        }
        return diff[n-1][m-1];
    }
}