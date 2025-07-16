class Solution {
    class Triple {
        int row;
        int col;
        int time;
        Triple(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Triple> que = new LinkedList<>();
        int countFresh = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = 2;
                    que.offer(new Triple(i, j, 0));
                }
                else if(grid[i][j] == 1) {
                    countFresh++;
                }
                else {
                    vis[i][j] = 0;
                }
            }
        }

        int[] rowCal = new int[] {1, 0, -1, 0};
        int[] colCal = new int[] {0, 1, 0, -1};
        int resultTime = 0;
        int count = 0;
        while(!que.isEmpty()) {
            Triple t = que.poll();
            int row = t.row;
            int col = t.col;
            int time = t.time;
            // System.out.println("Here");
            for(int i=0; i<4; i++) {
                int checkRow = row + rowCal[i];
                int checkCol = col + colCal[i];
                if(checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n && grid[checkRow][checkCol] == 1 && vis[checkRow][checkCol] != 2) {
                    que.offer(new Triple(checkRow, checkCol, (time + 1)));
                    vis[checkRow][checkCol] = 2;
                    count++;

                }
            }
            resultTime = Math.max(resultTime, time);
        }
        // System.out.println(countFresh + " " + count);
        if(count != countFresh) return -1;
        

        return resultTime;
    }
}