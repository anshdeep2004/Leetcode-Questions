// class Solution {
//     public int hIndex(int[] citations) {
//         int n = citations.length;
//         if(n == 1 && citations[0] == 0) {
//             return 0;
//         }
//         else if(n == 1) {
//             return 1;
//         }
//         else {
//             Arrays.sort(citations);
//             int max = 0;
//             for(int i=0; i<n; i++) {
//                 if(n - i >= citations[i]) {
//                     max = citations[i];
//                 }
//                 else {
//                     max = Math.min(citations[i], n-i);
//                 }
//             }
//             return max;
//         }
//     }
// }

// my above approach is close but not correct and giving wrong answers. Below is the correct approach.

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
		int len = citations.length;
		int hIndex = 0;
		for (int i = 0; i < len; i++) {
			int tempHIndex = Math.min(len - i, citations[i]);
			hIndex = Math.max(hIndex, tempHIndex);
		}
		return hIndex;
    }
}