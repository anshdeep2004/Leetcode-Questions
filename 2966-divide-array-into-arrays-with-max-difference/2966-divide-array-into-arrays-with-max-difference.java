class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while(i < n) {
            if((int) Math.abs(nums[i+2] - nums[i]) > k) {
                return new int[0][0];
            }
            int[] temp = new int[3];
            temp[0] = nums[i];
            temp[1] = nums[i+1];
            temp[2] = nums[i+2];
            result.add(temp);
            i += 3;
        }
        return result.toArray(new int[result.size()][]);
    }
}