class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long mod = 1000000007;
        int[] psn = prevSmallerNumber(arr);
        int[] nsen = nextSmallerEqualNumber(arr);
        long total = 0;
        int left, right;
        for(int i=0; i<n; i++) {
            left = i - psn[i];
            right = nsen[i] - i;
            total = (total + (long)(left * right * arr[i])) % mod;
        }
        return (int)total;
    }
    public int[] prevSmallerNumber(int[] arr) {
        int n = arr.length;
        int[] psn = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            psn[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psn;
    }
    public int[] nextSmallerEqualNumber(int[] arr) {
        int n = arr.length;
        int[] nsen = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            nsen[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nsen;
    }
}