class Solution {
    public int maxFreqSum(String s) {
        int maxVowel = 0;
        int maxCons = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            int f = freq.getOrDefault(s.charAt(i), 0);
            freq.put(s.charAt(i), f+1);
        }

        for(Map.Entry<Character, Integer> map : freq.entrySet()) {
            char ch = map.getKey();
            int val = map.getValue();

            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                maxVowel = Math.max(maxVowel, val);
            }
            else {
                maxCons = Math.max(maxCons, val);
            }
        }

        return maxVowel + maxCons;
    }
}