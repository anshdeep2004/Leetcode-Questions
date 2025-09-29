// Memoization
class Solution {
    public boolean isPallindrome(int i, int j, String s) {
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }

    public int f(int i, String s, int[] dp) {
        if(i == s.length()) return 0;
        int minCost = Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];

        for(int j=i; j<s.length(); j++) {
            if(isPallindrome(i, j, s)) {
                int cost = 1 + f(j+1, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(0, s, dp) - 1;
    }
}