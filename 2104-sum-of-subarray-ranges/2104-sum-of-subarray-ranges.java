class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] prevSmall = new int[n];
        int[] nextSmall = new int[n];
        int[] prevLarge = new int[n];
        int[] nextLarge = new int[n];

        // prevSmall
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            prevSmall[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // nextSmall
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            nextSmall[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        // prevLarge
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            prevLarge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        // nextLarge
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            nextLarge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        st.clear();

        long result = 0;
        for(int i=0; i<n; i++) {
            long smallTimes = (long) (i - prevSmall[i]) * (nextSmall[i] - i);
            long largeTimes = (long) (i - prevLarge[i]) * (nextLarge[i] - i);
            result += (largeTimes - smallTimes) * nums[i];
        }
        return result;

    }
}

// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         Stack<Integer> st = new Stack<>();
//         int[] prevSmall = new int[n];
//         int[] nextSmall = new int[n];
//         int[] prevLarge = new int[n];
//         int[] nextLarge = new int[n];

//         // prevSmall
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
//             prevSmall[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }
//         st.clear();

//         // nextSmall
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
//             nextSmall[i] = st.isEmpty() ? n : st.peek();
//             st.push(i);
//         }
//         st.clear();

//         // prevLarge
//         for (int i = 0; i < n; i++) {
//             while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
//             prevLarge[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }
//         st.clear();

//         // nextLarge
//         for (int i = n - 1; i >= 0; i--) {
//             while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
//             nextLarge[i] = st.isEmpty() ? n : st.peek();
//             st.push(i);
//         }

//         long result = 0;
//         for (int i = 0; i < n; i++) {
//             long small = (long)(i - prevSmall[i]) * (nextSmall[i] - i);
//             long large = (long)(i - prevLarge[i]) * (nextLarge[i] - i);
//             result += (large - small) * nums[i];
//         }
//         return result;
//     }
// }
