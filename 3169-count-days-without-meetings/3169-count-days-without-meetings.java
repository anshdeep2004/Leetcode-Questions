// class Solution {
//     public int countDays(int days, int[][] meetings) {
//         int n = meetings.length;
//         int maxEnd = 0;
//         Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
//         int count = meetings[0][1];
//         if(meetings[0][0] <= days) {
//             count += meetings[0][0] - 1;
//         }
//         else {
//             return count;
//         }
//         for(int i=0; i<n-1; i++) {
//             if(meetings[i][1] < meetings[i+1][0]) {
//                 if(meetings[i][1] <= days && meetings[i+1][0] <= days) {
//                     count += (meetings[i+1][0] - meetings[i][1] - 1);
//                 }
//                 else if(meetings[i][1] <= days) {
//                     count += days - meetings[i][1];
//                 }
//                 else {
//                     // do nothing
//                 }
//             }
//             maxEnd = Math.max(maxEnd,meetings[i+1][1])
//         }
//         if(meetings[n-1][1] <= days) {
//             count += days - meetings[n-1][1];
//         }
//         return count;
//     }
// }


class Solution {
    public int countDays(int days, int[][] meetings) {
        int count=0;
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int coveredEnd=meetings[0][1];
        for(int i=1;i<meetings.length;i++){
            if(coveredEnd<meetings[i][0]){
                count+=meetings[i][0]-coveredEnd-1;
                coveredEnd=meetings[i][1];
            }
            else{
                coveredEnd=Math.max(meetings[i][1],coveredEnd);
            }
        }
        if(meetings[0][0]!=1){
            count+=meetings[0][0]-1;
        }
        if(coveredEnd!=days){
            count+=days-coveredEnd;
        }
        return count;
    }
}