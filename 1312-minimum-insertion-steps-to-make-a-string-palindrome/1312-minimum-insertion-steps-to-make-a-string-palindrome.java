// The idea behind this question is explained in a small video of 11 min. Just go through it and you will get the concept of this question. Link: https://www.youtube.com/watch?v=xPBLEj41rFU
// 

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

    public int longestPalindromeSubseq(String s) {
        String revStr = new StringBuilder(s).reverse().toString();
        return longestCommonSubsequence(s, revStr);
    }

    public int minInsertions(String s) {
        int n = s.length();
        return n - longestPalindromeSubseq(s);
    }
}