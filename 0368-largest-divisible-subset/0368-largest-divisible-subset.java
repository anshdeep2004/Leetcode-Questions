class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        for(int i=0; i<n; i++) {
            hash[i] = i;
        }
        int max = 1;
        int lastIdx = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                }
            }
            if(dp[i] > max) {
                max = dp[i];
                lastIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(lastIdx != hash[lastIdx]) {
            ans.add(nums[lastIdx]);
            lastIdx = hash[lastIdx];
        }
        ans.add(nums[lastIdx]);
        return ans;
    }
}