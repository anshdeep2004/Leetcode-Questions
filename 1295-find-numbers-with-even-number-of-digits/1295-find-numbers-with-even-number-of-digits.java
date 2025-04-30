class Solution {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            int digits = countDigits(nums[i]);
            if(digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
    public int countDigits(int num) {
        int digits = 0;
        while(num != 0) {
            digits++;
            num /= 10;
        }
        return digits;
    }
}