class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        int n = nums.length;
        List<Long> ans = new ArrayList<>();
        Stack<Long> st = new Stack<>();

        st.push((long) nums[0]);
        for(int i=1; i<n; i++) {
            if(!st.isEmpty() && nums[i] == st.peek()) {
                long top = st.pop();
                Long sum = (long) nums[i] + top;
                st.push(sum);
            }
            else {
                st.push((long) nums[i]);
            }
        }
        while(!st.isEmpty()) {
            ans.add(st.pop());
        }
        Collections.reverse(ans);

        return ans;
    }
}