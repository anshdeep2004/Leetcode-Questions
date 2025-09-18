class Solution {
    public int cuts(int i, int j, int[] addCuts, int[][] dp) {
        if(i > j) return 0;
        int min = (int) 1e9;

        if(dp[i][j] != -1) return dp[i][j];

        for(int k=i; k<=j; k++) {
            int cost = addCuts[j+1] - addCuts[i-1] + cuts(i, k-1, addCuts, dp) + 
                        cuts(k+1, j, addCuts, dp);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] addCuts = new int[c+2];
        addCuts[0] = 0;
        for(int i=0; i<c; i++) {
            addCuts[i+1] = cuts[i];
        }
        addCuts[c+1] = n;
        Arrays.sort(addCuts);
        int[][] dp = new int[c+1][c+1];

        for(int i=0; i<c+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return cuts(1, c, addCuts, dp);
    }
}