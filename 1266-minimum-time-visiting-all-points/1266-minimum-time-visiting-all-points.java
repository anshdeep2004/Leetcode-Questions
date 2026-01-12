class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;

        for(int i=0; i<n-1; i++) {
            int xDis = (int) Math.abs(points[i][0] - points[i+1][0]);
            int yDis = (int) Math.abs(points[i][1] - points[i+1][1]);
            time += Math.max(xDis, yDis);
        }

        return time;
    }
}