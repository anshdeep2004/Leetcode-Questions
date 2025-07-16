class Solution {
    class Triple {
        int row;
        int col;
        int dist;
        Triple(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<Triple> que = new LinkedList<>();
        int[][] vis = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    que.offer(new Triple(i, j, 0));
                }
                else {
                    // do nothing
                }
            }
        }

        int[] rowCal = new int[] {1, 0, -1, 0};
        int[] colCal = new int[] {0, 1, 0, -1};
        while(!que.isEmpty()) {
            Triple t = que.poll();
            int row = t.row;
            int col = t.col;
            int dist = t.dist;
            for(int i=0; i<4; i++) {
                int checkRow = row + rowCal[i];
                int checkCol = col + colCal[i];
                if(checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n && mat[checkRow][checkCol] == 1 && vis[checkRow][checkCol] == 0) {
                    que.offer(new Triple(checkRow, checkCol, (dist + 1)));
                    vis[checkRow][checkCol] = dist + 1;
                }
            }
        }
        return vis;
    }
}