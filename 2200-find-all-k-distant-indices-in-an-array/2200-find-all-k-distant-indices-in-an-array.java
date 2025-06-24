class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        Set<Integer> keyIndex = new TreeSet<>();
        for(int i=0; i<n; i++) {
            if(nums[i] == key) {
                keyIndex.add(i);
                int j = i;
                while(j >= 0 && (i-j) <= k) {
                    keyIndex.add(j);
                    j--;
                }
                j = i;
                while(j < n && (j-i) <= k) {
                    keyIndex.add(j);
                    j++;
                }
            }
        }
        return new ArrayList<>(keyIndex);
    }
}