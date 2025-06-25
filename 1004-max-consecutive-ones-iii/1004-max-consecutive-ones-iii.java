class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        List<Integer> numZero = new ArrayList<>();
        int start = 0;
        int maxStreak = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                numZero.add(i);
                if(numZero.size() > k) {
                    int firstZero = numZero.remove(0);
                    start = firstZero + 1;
                }
            }
            maxStreak = Math.max(maxStreak, (i - start + 1));
        }
        return maxStreak;
    }
}