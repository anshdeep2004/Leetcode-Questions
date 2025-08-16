// The nornmal logic behind this question is that if we want the Longest Palindromic Subsequence then we will just use Longet Common Subsequence logic. The thing if we reverse the given string then also the palindromic string remains the same and remains the biggest pallindromic subsequence in the reversed string also. So the simple thing that we have to do is that we just need to calculate the Longest Common Subsequence for the given string and reverse of the given string.

class Solution {
    // this the space optimised code of Longest Common subsequence. If need the Tabulation or Memoization then just visit the code of 1143. Longest Common Subsequence.
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
}