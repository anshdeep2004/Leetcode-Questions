class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int diff;
            if(i != n-1) {
                diff = (int) Math.abs(nums[i] - nums[i+1]);
            }
            else {
                diff = (int) Math.abs(nums[i] - nums[0]);
            }
            if(diff > max) {
                max = diff;
            }
        }
        return max;
    }
}