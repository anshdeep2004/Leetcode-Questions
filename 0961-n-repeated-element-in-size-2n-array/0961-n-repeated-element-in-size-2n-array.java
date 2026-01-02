class Solution {
    public int repeatedNTimes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int ans = -1;
        for(int num : nums) {
            if(list.contains(num)) {
                ans = num;
                break;
            }
            else {
                list.add(num);
            }
        }
        
        return ans;
    }
}