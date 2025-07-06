// class Solution {
//     public int[][] merge(int[][] intervals) {
//         int n = intervals.length;
//         int i = 0;
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         List<int[]> result = new ArrayList<>();

//         // Add unmergerd Intervals.
//         while(i < n-1 && intervals[i][1] < intervals[i+1][0]) {
//             result.add(intervals[i]);
//             i++;
//         }
        
//         // Add the merging intervals.
//         int min = intervals[i][0];
//         int max = intervals[i][1];
//         while(i < n && intervals[i][0] <= max) {
//             min = Math.min(min, intervals[i][0]);
//             max = Math.max(max, intervals[i][1]);
//             i++;
//         }
//         int[] temp = new int[] {min, max};
//         result.add(temp);

//         // Add remaining intervals
//         while(i < n) {
//             result.add(intervals[i]);
//             i++;
//         }
//         return result.toArray(new int[result.size()][]);
//     }
// }

class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int i = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        while (i < n) {
            int min = intervals[i][0];
            int max = intervals[i][1];

            // Merge all overlapping intervals
            while (i + 1 < n && intervals[i + 1][0] <= max) {
                i++;
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            }

            result.add(new int[]{min, max});
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}