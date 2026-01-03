class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = n - 1;
        int mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;
            int tempCount = 0;
            for(int i=0; i<n; i++) {
                if(nums[i] <= mid) {
                    tempCount++;
                }
            }
            if(tempCount <= mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return left;
    }
}