// Memoization
class Solution {
    public boolean match(int i, int j, String p, String s, Boolean[][] dp) {
        if(i < 0 && j < 0) return true;
        if(i < 0) return false;
        if(j < 0) {
            for(int k=0; k<=i; k++) {
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != null) return dp[i][j];

        if(p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            return dp[i][j] = match(i-1, j-1, p, s, dp);
        }
        else if(p.charAt(i) == '*') {
            return dp[i][j] = match(i-1, j, p, s, dp) | match(i, j-1, p, s, dp);
        }
        else {
            return false;
        }
    }

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[m][n];
        
        // the match function code is written such that that we are considering the ? and * string as the first string do in the parameters we are first sending p and then s and same goes with their lengths also
        return match(m-1, n-1, p, s, dp);
    }
}