// class Solution {
//     public boolean[] subsetSumEqualsK(int[] nums, int k) {
//         int n = nums.length;
//         boolean[] prevRow = new boolean[k+1];
//         boolean[] temp = new boolean[k+1];

//         prevRow[0] = true;

//         for(int i=1; i<=n; i++) {
//             for(int target=1; target<=k; target++) {
//                 boolean take = prevRow[target];
//                 boolean noTake = false;
//                 if(target >= nums[i-1]) {
//                     noTake = prevRow[target - nums[i-1]];
//                 }
//                 temp[target] = take | noTake;
//             }
//             prevRow = temp;
//         }
//         return prevRow;
//     }
//     public int minimumDifference(int[] nums) {
//         int totalSum = 0;
//         for(int i=0; i<nums.length; i++) {
//             totalSum += nums[i];
//         }
//         boolean[] arr = subsetSumEqualsK(nums, totalSum);
//         int minDiff = (int) 1e9;
//         for(int i=0; i<=totalSum; i++) {
//             if(arr[i] == true) {
//                 minDiff = Math.min(minDiff, Math.abs(2*i - totalSum)); // i - (totalSum - i)
//             }
//         }
//         return minDiff;
//     }
// }

// The above solution will work if and only if the integers in the array nums is positive, but in case of negative integers this approach will not work. The below approach holds good for thenegative integers also.

import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;

        // Split into two halves
        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        // Get all subset sums grouped by subset size
        Map<Integer, List<Integer>> leftMap = getSubsetSums(left);
        Map<Integer, List<Integer>> rightMap = getSubsetSums(right);

        int totalSum = Arrays.stream(nums).sum();
        int target = totalSum / 2;

        int ans = Integer.MAX_VALUE;

        // Try all possible ways to take sizeLeft from left and sizeRight from right
        for (int sizeLeft = 0; sizeLeft <= n; sizeLeft++) {
            List<Integer> listL = leftMap.get(sizeLeft);
            List<Integer> listR = rightMap.get(n - sizeLeft);

            Collections.sort(listR); // For binary search

            for (int sumL : listL) {
                int need = target - sumL;

                int idx = Collections.binarySearch(listR, need);
                if (idx < 0) idx = -idx - 1;

                // Check candidate at idx
                if (idx < listR.size()) {
                    int sumChosen = sumL + listR.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sumChosen));
                }

                // Check candidate just before idx
                if (idx > 0) {
                    int sumChosen = sumL + listR.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sumChosen));
                }
            }
        }

        return ans;
    }

    // Generate all subset sums and group them by subset size
    private Map<Integer, List<Integer>> getSubsetSums(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            int bits = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    bits++;
                }
            }
            map.computeIfAbsent(bits, k -> new ArrayList<>()).add(sum);
        }
        return map;
    }
}
