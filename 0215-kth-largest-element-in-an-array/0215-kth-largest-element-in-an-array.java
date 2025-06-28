class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int kLarge = 0;
        for(int i=0; i<n; i++) {
            pq.add(nums[i]);
        }
        for(int j=0; j<k-1; j++) {
            pq.poll();
        }
        return pq.peek();
    }
}