class Solution {
    private void dfs(int row, int col, int[][] vis, int[][] grid) {
        vis[row][col] = 1;

        int[] rowCal = new int[] {1, 0, -1, 0};
        int[] colCal = new int[] {0, 1, 0, -1};
        for(int i=0; i<4; i++) {
            int checkRow = row + rowCal[i];
            int checkCol = col + colCal[i];
            if(checkRow >= 0 && checkRow < grid.length && checkCol >= 0 && checkCol < grid[0].length && grid[checkRow][checkCol] == 1 && vis[checkRow][checkCol] != 1) {
                dfs(checkRow, checkCol, vis, grid);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int countLand = 0;

        for(int i=0; i<m; i++) {
            if(grid[i][0] == 1) {
                dfs(i, 0, vis, grid);
            }
        }
        for(int i=0; i<n; i++) {
            if(grid[0][i] == 1) {
                dfs(0, i, vis, grid);
            }
        }
        for(int i=0; i<m; i++) {
            if(grid[i][n-1] == 1) {
                dfs(i, n-1, vis, grid);
            }
        }
        for(int i=0; i<n; i++) {
            if(grid[m-1][i] == 1) {
                dfs(m-1, i, vis, grid);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && vis[i][j] != 1) {
                    countLand++;
                }
            }
        }
        return countLand;
    }
}