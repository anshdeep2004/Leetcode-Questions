class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        while(r < n) {
            freq.put(s.charAt(r), freq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s.charAt(r)));
            if((r-l+1) - maxFreq > k) {
                freq.put(s.charAt(l), freq.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, (r-l+1));
            r++;
        }
        return maxLen;
    }
}