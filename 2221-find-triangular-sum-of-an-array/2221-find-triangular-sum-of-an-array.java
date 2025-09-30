class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        ArrayList<Integer> prev = new ArrayList<>();
        for(int i=0; i<n; i++) {
            prev.add(nums[i]);
        }
        ArrayList<Integer> curr = new  ArrayList<>();

        for(int i=1; i<n; i++) {
            for(int j=0; j<prev.size()-1; j++) {
                curr.add((prev.get(j) + prev.get(j+1)) % 10);
            }
            prev.clear();
            prev.addAll(curr);
            curr.clear();
        }
        return prev.get(0);
    }
}