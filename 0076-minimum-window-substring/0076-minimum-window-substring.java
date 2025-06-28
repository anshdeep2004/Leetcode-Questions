class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int r = 0;
        int l = 0;
        int count = 0;
        int startIdx = -1;
        int endIdx = -1;
        int minLen = Integer.MAX_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<m; i++) {
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) + 1);
        }
        while(r < n) {
            if(hm.getOrDefault(s.charAt(r), 0) > 0) {
                count++;
            }
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) - 1);
            while(count == m) {
                if((r - l + 1) < minLen) {
                    startIdx = l;
                    endIdx = r;
                    minLen = r - l + 1;
                }
                hm.put(s.charAt(l), hm.get(s.charAt(l)) + 1);
                if(hm.get(s.charAt(l)) > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        if(startIdx == -1 || endIdx == -1) {
            return "";
        }
        return s.substring(startIdx, endIdx+1);
    }
}