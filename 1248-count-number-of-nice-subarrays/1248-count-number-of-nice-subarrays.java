class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int oddNums = 0;
        int count = 0;
        while(r < n) {
            if(nums[r] % 2 != 0) {
                oddNums++;
            }
            while(oddNums > k) {
                if(nums[l] % 2 != 0) {
                    oddNums--;
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return (count - numberOfSubarrays_with_K_minus_one_nice_subarrays(nums, (k-1)));
    }
    public int numberOfSubarrays_with_K_minus_one_nice_subarrays(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int oddNums = 0;
        int count = 0;
        while(r < n) {
            if(nums[r] % 2 != 0) {
                oddNums++;
            }
            while(oddNums > k) {
                if(nums[l] % 2 != 0) {
                    oddNums--;
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}