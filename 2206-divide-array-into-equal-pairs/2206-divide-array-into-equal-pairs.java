class Solution {
    public boolean divideArray(int[] nums) {
        int n1 = nums.length;
        Map<Integer, Integer> arr = new HashMap<>();
        for(int i=0; i<n1; i++) {
           arr.put(nums[i], arr.getOrDefault(nums[i], 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : arr.entrySet()) {
            int val = entry.getValue();
            System.out.println(entry.getKey() + " : " + val);
            if(val % 2 == 1) {
                return false;
            }
            else {
                // do nothing
            }
        }
        return true;
    }
}