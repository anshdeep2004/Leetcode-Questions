class Solution {
    public int minBitFlips(int start, int goal) {
        String startBinary = Integer.toBinaryString(start);
        String goalBinary = Integer.toBinaryString(goal);
        int flips = 0;
        if(startBinary.length() > goalBinary.length()) {
            int diff = startBinary.length() - goalBinary.length();
            int i;
            for(i=0; i<diff; i++) {
                if(startBinary.charAt(i) == '1') {
                    flips++;
                }
            }
            for(int j=0; j<goalBinary.length(); j++) {
                if(goalBinary.charAt(j) != startBinary.charAt(i)) {
                    flips++;
                }
                i++;
            }
        }
        else if(startBinary.length() < goalBinary.length()) {
            int diff = goalBinary.length() - startBinary.length();
            int i;
            for(i=0; i<diff; i++) {
                if(goalBinary.charAt(i) == '1') {
                    flips++;
                }
            }
            for(int j=0; j<startBinary.length(); j++) {
                if(startBinary.charAt(j) != goalBinary.charAt(i)) {
                    flips++;
                }
                i++;
            }
        }
        else {
            for(int j=0; j<startBinary.length(); j++) {
                if(startBinary.charAt(j) != goalBinary.charAt(j)) {
                    flips++;
                }
            }
        }
        return flips;
    }
}