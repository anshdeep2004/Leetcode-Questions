class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r < n) {
            sum += nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r -l + 1);
            r++;
        }
        return (count - numSubarraysWithSumOneLessThanGoal(nums, (goal-1)));
    }

    public int numSubarraysWithSumOneLessThanGoal(int[] nums, int goal) {
        if(goal < 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r < n) {
            sum += nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            count += (r -l + 1);
            r++;
        }
        return count;
    }
}