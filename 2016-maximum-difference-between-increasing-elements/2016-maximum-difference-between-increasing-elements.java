class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int diff = -1;
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int tempDiff = nums[j] - nums[i];
                if(tempDiff > diff) {
                    diff = tempDiff;
                }
            }
        }
        if(diff == 0) {
            diff = -1;
        }
        return diff;
    }
}