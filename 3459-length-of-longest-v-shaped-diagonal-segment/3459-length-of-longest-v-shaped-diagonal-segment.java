class Solution {
    private int n,m;
    private int[][] grid;
    private int[][][][] dp;
    private final int[][] dirs={{1,1},{1,-1},{-1,-1},{-1,1}};
    private boolean check(int x,int y,int t){
        return x<0||y<0||y>=m||x>=n||grid[x][y]!=t;
    }
    private int helper(int i,int j,int d,boolean t,int tar){
        int nx=i+dirs[d][0],ny=j+dirs[d][1];
        if(check(nx,ny,tar)) return 0;
        int tur=t?1:0;
        if(dp[nx][ny][d][tur]!=-1) return dp[nx][ny][d][tur];
        int max=helper(nx,ny,d,t,2-tar);
        if(t) max=Math.max(max,helper(nx,ny,(d+1)%4,false,2-tar));
        return dp[nx][ny][d][tur]=max+1;
    }
    public int lenOfVDiagonal(int[][] grid) {
        this.n=grid.length;
        this.m=grid[0].length;
        this.grid=grid;
        dp=new int[n][m][4][2];
        int ans=0;
        for(int[][][] a:dp) for(int[][] b:a) for(int[] c:b) Arrays.fill(c,-1);
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) if(grid[i][j]==1) for(int d=0;d<4;d++) ans=Math.max(ans,helper(i,j,d,true,2)+1);
        return ans;
    }
}