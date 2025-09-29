// Memoization
class Solution {
    public int f(int i, int[] arr, int k, int[] dp) {
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];

        int len = 0;
        int max = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int j=i; j<Math.min(i+k, arr.length); j++) {
            len++;
            max = Math.max(max, arr[j]);
            int sum = len * max + f(j+1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[i] = maxSum;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0, arr, k, dp);
    }
}