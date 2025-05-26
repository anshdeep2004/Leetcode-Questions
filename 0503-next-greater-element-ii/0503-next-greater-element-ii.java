class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            int flag = 0;
            for(int j=i+1; j<n; j++) {
                if(nums[j] > nums[i]) {
                    result[i] = nums[j];
                    flag = 1;
                    break;
                }
            }
            if(flag == 1) {
                continue;
            }
            for(int k=0; k<i; k++) {
                if(nums[k] > nums[i]) {
                    result[i] = nums[k];
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                result[i] = -1;
            }
        }
        return result;
    }
}