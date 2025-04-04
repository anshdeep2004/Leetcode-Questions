class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preffix = new int[n];
        int[] suffix = new int[n];
        preffix[0] = 1;
        suffix[n-1] = 1;
        for(int i=1, j=n-2; i<n && j >=0; i++, j--) {
            preffix[i] = preffix[i-1] * nums[i-1];
            suffix[j] = suffix[j+1] * nums[j+1];
        }
        int[] answer = new int[n];
        for(int k=0; k<n; k++) {
            answer[k] = preffix[k] * suffix[k];
        }
        return answer;
    }
}