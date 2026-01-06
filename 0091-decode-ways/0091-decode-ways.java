// Memoization solution
class Solution {
    public int decodeWays(int i, String s, int[] dp) {
        if(i == s.length()) return 1;

        if(dp[i] != -1) return dp[i];

        if(s.charAt(i) == '0') return 0;

        int ways = 0;

        ways += decodeWays(i+1, s, dp);

        if(i+1 < s.length()) {
            int check = Integer.parseInt(s.substring(i, i+2));
            if(check >= 10 && check <= 26) {
                ways += decodeWays(i+2, s, dp);
            }
        }

        dp[i] = ways;
        return ways;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return decodeWays(0, s, dp);
    }
}