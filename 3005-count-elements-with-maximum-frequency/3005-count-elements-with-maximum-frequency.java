class Solution {
    public int maxFrequencyElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 1;
        int maxCount = 0;
        // int freq = 1;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> map : freq.entrySet()) {
            int key = map.getKey();
            int val = map.getValue();

            if(val > max) {
                max = val;
                maxCount = 1;
            }
            else if(val == max) {
                maxCount++;
            }
        }

        return max * maxCount;
    }
}