class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> que = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        int[][] vis = new int[n][n];
        vis[0][0] = 1;
        que.offer(new int[] {grid[0][0], 0, 0});
        int[] rc = new int[] {0, 1, 0, -1};
        int[] cc = new int[] {1, 0, -1, 0};
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int maxLevel = arr[0];
            int row = arr[1];
            int col = arr[2];
            if(row == n-1 && col == n-1) return maxLevel;
            for(int i=0; i<4; i++) {
                int adjRow = row + rc[i];
                int adjCol = col + cc[i];
                // int adjLevel = grid[adjRow][adjCol];
                if(adjRow >= 0 && adjRow <n && adjCol >=0 && adjCol < n && vis[adjRow][adjCol] != 1) {
                    vis[adjRow][adjCol] = 1;
                    int newMaxLevel = Math.max(maxLevel, grid[adjRow][adjCol]);
                    que.offer(new int[] {newMaxLevel, adjRow, adjCol});
                }
            }
        }
        return -1;
    }
}