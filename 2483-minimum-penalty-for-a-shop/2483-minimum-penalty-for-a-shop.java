class Solution {
    public int bestClosingTime(String customers) {
        int len = customers.length();

        int y = 0;
        int n = 0;
        int penalty = Integer.MAX_VALUE;
        int minHr = Integer.MAX_VALUE;

        for(char ch : customers.toCharArray()) {
            if(ch == 'Y') y++;
        }

        penalty = y + n;

        for(int i=0; i<len; i++) {
            if(customers.charAt(i) == 'Y') {
                y--;
                if((y + n) < penalty) {
                    penalty = y + n;
                    minHr = i+1;
                }
            }
            else if(customers.charAt(i) == 'N') {
                n++;
            }
            else {
                // invalid character
            }
        }

        if(minHr > len) return 0;

        return minHr;
    }
}