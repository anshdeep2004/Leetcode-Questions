class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] != 9) {
            digits[n-1] += 1;
        }
        else {
            int i = n-1;
            while(i >= 1 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }
            if(i == 0 && digits[0] == 9) {
                int[] result = new int[n+1];
                result[0] = 1;
                //System.out.println("Here");
                return result;
            }
            else {
                digits[i] += 1; 
            }
        }
        return digits;
    }
}