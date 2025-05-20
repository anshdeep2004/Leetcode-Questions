class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        if(n == 0) return true;
        // if(n == 1) {
        //     if(nums[0] == 1) return true;
        //     else return false;
        // }
        int q = queries.length;
        for(int i=0; i<q; i++) {
            for(int j=queries[i][0]; j<=queries[i][1]; j++) {
                if(nums[j] > 0) nums[j] -= 1;
            }
        }
        if(Arrays.stream(nums).allMatch(x -> x == 0)) return true;
        else return false;
    }
}