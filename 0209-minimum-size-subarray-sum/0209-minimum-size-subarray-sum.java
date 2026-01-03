// Solution using sliding window approach.
// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int n = nums.length;
//         int i = 0;
//         int sum = 0;
//         int minLen = Integer.MAX_VALUE;

//         for (int j = 0; j < n; j++) {
//             sum += nums[j]; // expand window

//             while (sum >= target) {
//                 minLen = Math.min(minLen, j - i + 1);
//                 sum -= nums[i]; // shrink window
//                 i++;
//             }
//         }

//         return minLen == Integer.MAX_VALUE ? 0 : minLen;
//     }
// }

// Solution using Binary search approach
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 1, right = n;
        int minLen = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if any subarray of length mid has sum >= target
            boolean found = false;

            int windowSum = 0;

            // Initial window sum
            for (int i = 0; i < mid; i++) {
                windowSum += nums[i];
            }

            if (windowSum >= target) {
                found = true;
            } else {
                // Slide the window
                for (int i = mid; i < n; i++) {
                    windowSum += nums[i];
                    windowSum -= nums[i - mid];

                    if (windowSum >= target) {
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                minLen = mid;        // possible answer
                right = mid - 1;     // try smaller length
            } else {
                left = mid + 1;      // need bigger subarray
            }
        }

        return minLen;
    }
}