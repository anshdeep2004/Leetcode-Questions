class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder str = new StringBuilder();
        int i = 0;
        while(i < n) {
            int count = 1;
            str.append(s.charAt(i));
            while(i < n-1 && s.charAt(i) == s.charAt(i+1)) {
                count++;
                if(count > 2) {
                    i++;
                    continue;
                }
                str.append(s.charAt(i));
                i++;
            }
            i++;
        }
        return str.toString();
    }
}