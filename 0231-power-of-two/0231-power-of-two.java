class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) {
            return false;
        }
        int i = 0;
        while(Math.pow(2, i) <= n) {
            i++;
        }
        if(Math.pow(2, i-1) == n) return true;
        else return false;
    }
}