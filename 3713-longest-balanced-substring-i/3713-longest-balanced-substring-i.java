class Solution {
    public boolean checkBalance(int[] freq) {
        int minFreq = 1001;
        int maxFreq = 0;

        for(int i=0; i<freq.length; i++) {
            if(freq[i] != 0) {
                minFreq = Math.min(minFreq, freq[i]);
                maxFreq = Math.max(maxFreq, freq[i]);
            }
        }

        return minFreq == maxFreq;
    }

    public int longestBalanced(String s) {
        // First calculate all the substrings. And for every substring we have to see the frequencies of characters of the of the string. If the min freq and max freq are the same then the string is definitely balanced.

        int n = s.length();
        int ans = 0;

        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;
                if(checkBalance(freq)) {
                    ans = Math.max(ans, (j-i+1));
                }
            }
        }

        return ans;
    }
}