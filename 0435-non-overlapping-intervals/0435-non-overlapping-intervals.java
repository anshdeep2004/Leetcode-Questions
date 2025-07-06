class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int i = 1;
        int max = intervals[0][1];
        int count = 0;
        while(i < n) {
            if(intervals[i][0] >= max) {
                max = intervals[i][1];
            }
            else {
                count++;
            }
            i++;
        }
        return count;
    }
}