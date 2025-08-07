class Solution {
    public int rob(int[] nums) {
        // Now the logic is that if the first and the last elements are adjecent, then the simple logic says that only one of them can be in the answer. So used the normal logic of House Robber (1st part of this question) for both first excluding the first element and then excluding the last element.
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i=1; i<n-1; i++) {
            int pick = nums[i];
            if(i > 1) pick += prev2;
            int nonPick = prev1;

            int curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        int firstAns = prev1;

        if(n > 1) prev1 = nums[1];
        prev2 = 0;
        for(int i=2; i<n; i++) {
            int pick = nums[i];
            if(i > 2) pick += prev2;
            int nonPick = prev1;

            int curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        int lastAns = prev1;

        return Math.max(firstAns, lastAns);
    }
}