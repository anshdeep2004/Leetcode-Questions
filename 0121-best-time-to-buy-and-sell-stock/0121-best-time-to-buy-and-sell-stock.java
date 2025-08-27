class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int leftMin = prices[0];
        for(int i=1; i<n; i++) {
            int newProf = prices[i] - leftMin;
            maxProfit = Math.max(maxProfit, newProf);
            leftMin = Math.min(leftMin, prices[i]);
        }
        return maxProfit;
    }
}