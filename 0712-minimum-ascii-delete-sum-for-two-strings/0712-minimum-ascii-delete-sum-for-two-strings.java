class Solution {
    public int getMaxLCSAsciiSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        for(int i=1; i<=n1; i++) {
            for(int j=1; j<=n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];
    }
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int LCSAsciiSum = getMaxLCSAsciiSum(s1, s2);
        int s1AsciiTotal = 0;
        int s2AsciiTotal = 0;

        for(int i=0; i<n1; i++) {
            s1AsciiTotal += (int) s1.charAt(i);
        }
        for(int j=0; j<n2; j++) {
            s2AsciiTotal += (int) s2.charAt(j);
        }

        return (s1AsciiTotal + s2AsciiTotal - 2*LCSAsciiSum);
    }
}