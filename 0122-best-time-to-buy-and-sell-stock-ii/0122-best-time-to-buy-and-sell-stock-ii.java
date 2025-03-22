// class Solution {
//     public int maxProfit(int[] prices) {
//         int p = 0;
//         int q = 0;
//         int max = 0;
//         int n = prices.length;
//         for(int i=0; i<n-1; i++) {
//             if(prices[i] > prices[i+1]) {
//                 max += prices[i] - prices[p];
//                 p = i+1;
//             }
//             else {
//                 q = i+1;
//             }
//         }
//         if(max == 0) {
//             max = prices[q] - prices[0];
//         }
//         return max;
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int p = 0;
        int q = 1;
        int sum = 0;
        while(p < n && q < n) {
            if(prices[p] < prices[q]) {
                sum += prices[q] - prices[p];
            }
            else {
                // do nothing
            }
            p++;
            q++;
        }
        return sum;
    }
}