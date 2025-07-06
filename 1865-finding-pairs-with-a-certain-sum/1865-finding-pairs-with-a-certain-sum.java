class FindSumPairs {
    int [] nums1;
    int [] nums2;
    HashMap<Integer, Integer> freq;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        freq = new HashMap<>();
        for(int num : nums2) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int prevVal = nums2[index];
        freq.put(prevVal, freq.get(prevVal) - 1);
        nums2[index] += val;
        freq.put(nums2[index], freq.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int pairs = 0;
        for(int num : nums1) {
            int restPart = tot - num;
            pairs += freq.getOrDefault(restPart, 0);
        }
        return pairs;
    }
}