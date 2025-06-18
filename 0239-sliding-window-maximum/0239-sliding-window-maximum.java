class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<n; i++) {
            // to check if the first element is in the window or not. If it's not then pop it.
            if(!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();

            // pop last till we get an element which is greater than the ith element. EWe have to make a monotonic stack like thing which is in the decreasing order from the first to last element.
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) dq.pollLast();

            // add the ith element to stack.
            dq.addLast(i);

            // if i has crossed the first window that means after this on every element we have to get the maximum of each window (after this it's less important to read) when an element is added to the last and non required elements are removed from first of dq. 
            if(i >= k-1) result[i-k+1] = nums[dq.peekFirst()];
        }
        return result;
    }
}