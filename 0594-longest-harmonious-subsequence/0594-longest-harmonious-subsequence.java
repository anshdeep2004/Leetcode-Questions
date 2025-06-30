class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int maxLen = 0;
        Arrays.sort(nums);
        TreeSet<Integer> ts = new TreeSet<>();
        while(r < n) {
            ts.add(nums[r]);
            if(ts.size() == 2 && ts.last() - ts.first() == 1) {
                maxLen = Math.max(maxLen, (r - l + 1));
            }
            while(ts.size() > 2 || (ts.size() == 2 && ts.last() - ts.first() > 1)) {
                if(nums[l] != ts.first()) {
                    ts.pollFirst();
                    break;
                }
                l++;
            }
            r++;
        }
        return maxLen;
    }
}