class Solution {
    class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> que = new LinkedList<>();
        
        for(int i=0; i<m; i++) {
            vis[i] = image[i].clone();
        }

        int startColor = image[sr][sc];
        vis[sr][sc] = color;
        que.offer(new Pair(sr, sc));

        int[] rowCal = new int[] {1, 0, -1, 0};
        int[] colCal = new int[] {0, 1, -0, -1};
        while(!que.isEmpty()) {
            Pair p = que.poll();
            int row = p.row;
            int col = p.col;
            for(int i=0; i<4; i++) {
                int checkRow = row + rowCal[i];
                int checkCol = col + colCal[i];
                if(checkRow >= 0 && checkRow < m && checkCol >= 0 && checkCol < n && image[checkRow][checkCol] == startColor && vis[checkRow][checkCol] != color) {
                    que.offer(new Pair(checkRow, checkCol));
                    vis[checkRow][checkCol] = color;
                }
            }
        }
        return vis;
    }
}