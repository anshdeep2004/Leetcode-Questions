class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size() > k) {
            pq.poll(); // remove the smallest so only k largest remain
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */