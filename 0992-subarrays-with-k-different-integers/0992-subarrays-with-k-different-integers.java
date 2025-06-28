class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        while(r < n) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            while(hm.size() > k) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if(hm.get(nums[l]) == 0) {
                    hm.remove(nums[l]);
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count - subarraysWithK_minus_one_Distinct(nums, (k-1));
    }

    public int subarraysWithK_minus_one_Distinct(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;
        while(r < n) {
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            while(hm.size() > k) {
                hm.put(nums[l], hm.get(nums[l]) - 1);
                if(hm.get(nums[l]) == 0) {
                    hm.remove(nums[l]);
                }
                l++;
            }
            count += (r - l + 1);
            r++;
        }
        return count;
    }
}