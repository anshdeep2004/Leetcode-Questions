class Solution {
    public void dfs(int[] arr, char[][] grid, HashMap<int[], Integer> oneList) {
        oneList.put(arr, 1);
        int[] xDir = {-1, 0, 0, 1};
        int[] yDir = {0, 1, -1, 0};

        for(int i=0; i<4; i++) {
            int x = arr[0] + xDir[i];
            int y = arr[1] + yDir[i];
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == '1') {
                for(Map.Entry<int[], Integer> map : oneList.entrySet()) {
                    int[] key = map.getKey();
                    int val = map.getValue();
                    if(key[0] == x && key[1] == y && val == 0) {
                        dfs(key, grid, oneList);
                        break;
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashMap<int[], Integer> oneList = new HashMap<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == '1') {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    oneList.put(arr, 0);
                }
            }
        }

        int islands = 0;

        for(Map.Entry<int[], Integer> map : oneList.entrySet()) {
            if(map.getValue() == 0) {
                islands++;
                dfs(map.getKey(), grid, oneList);
            }
        }

        return islands;
    }
}