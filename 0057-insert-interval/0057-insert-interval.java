// class Solution {
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         int n = intervals.length;
//         List<int[]> result = new ArrayList<>();
//         int i = 0;
//         while(i < n) {
//             if((intervals[i][0] < newInterval[0] && intervals[i][1] < newInterval[1]) || (intervals[i][0] > newInterval[0] && intervals[i][1] > newInterval[1]) ) {
//                 int[] temp = new int[2];
//                 temp[0] = intervals[i][0];
//                 temp[1] = intervals[i][1];
//                 result.add(temp);
//                 i++;
//             }
//             else {
//                 int min = newInterval[0];
//                 int max = newInterval[1];
//                 while(i < n && (intervals[i][0] > min && intervals[i][1] > max)) {
//                     min = Math.min(min, intervals[i][0]);
//                     max = Math.max(max, intervals[i][1]);
//                     i++;
//                 }
//                 int[] temp = new int[2];
//                 temp[0] = min;
//                 temp[1] = max;
//                 result.add(temp);
//             }
//         }
//         int[][] res =  new int[result.size()][2];
//         for(int j=0; j<result.size(); j++) {
//             res[j] = result.get(j);
//         }
//         return res;
//     }
// }

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // Step 1: Add all intervals before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i++]);
        }

        // Step 2: Merge all overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);  // Add the merged interval

        // Step 3: Add all remaining intervals after newInterval
        while (i < n) {
            result.add(intervals[i++]);
        }

        // Convert list to array
        return result.toArray(new int[result.size()][]);
    }
}
