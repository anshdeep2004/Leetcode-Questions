class Solution {
    private void dfs(int row, int col, int[][] vis, char[][] board) {
        vis[row][col] = 1;

        int[] rowCal = new int[] {1, 0, -1, 0};
        int[] colCal = new int[] {0, 1, 0, -1};
        for(int i=0; i<4; i++) {
            int checkRow = row + rowCal[i];
            int checkCol = col + colCal[i];
            if(checkRow >= 0 && checkRow < board.length && checkCol >= 0 && checkCol < board[0].length && board[checkRow][checkCol] == 'O' && vis[checkRow][checkCol] != 1) {
                dfs(checkRow, checkCol, vis, board);
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board.length;
        int[][] vis = new int[m][n];

        for(int i=0; i<m; i++) {
            if(board[i][0] == 'O') {
                dfs(i, 0, vis, board);
            }
        }
        for(int i=0; i<n; i++) {
            if(board[0][i] == 'O') {
                dfs(0, i, vis, board);
            }
        }
        for(int i=0; i<m; i++) {
            if(board[i][n-1] == 'O') {
                dfs(i, n-1, vis, board);
            }
        }
        for(int i=0; i<n; i++) {
            if(board[m-1][i] == 'O') {
                dfs(m-1, i, vis, board);
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j] != 1) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}