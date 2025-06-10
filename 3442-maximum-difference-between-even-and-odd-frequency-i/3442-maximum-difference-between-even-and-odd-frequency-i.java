class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(int i=0; i<n; i++) {
            int index = s.charAt(i) - 'a';
            freq[index]++;
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        for(int j=0; j<26; j++) {
            if(freq[j] != 0 && freq[j] % 2 == 0 && freq[j] < minEven) {
                minEven = freq[j];
            }
            if(freq[j] != 0 && freq[j] % 2 != 0 && freq[j] > maxOdd) {
                maxOdd = freq[j];
            }
        }
        return (maxOdd - minEven);
    }
}