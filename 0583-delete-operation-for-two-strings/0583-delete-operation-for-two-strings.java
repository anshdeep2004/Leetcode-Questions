class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        
        for(int i=0; i<=m; i++) {
            prev[i] = 0;
        }

        for(int i=1; i<=n; i++) {
            curr = new int[m+1];
            for(int j=1; j<=m; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        return n + m - 2 * longestCommonSubsequence(word1, word2);
    }
}