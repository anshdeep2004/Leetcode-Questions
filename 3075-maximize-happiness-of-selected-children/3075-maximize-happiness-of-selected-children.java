class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        long sum = 0;
        Arrays.sort(happiness);

        for(int i=n-1; i>=n-k; i--) {
            if(happiness[i] >= (n-i-1)) {
                sum += happiness[i] - (n-i-1);
            }
            else {
                sum += 0;
            }
        }

        return sum;
    }
}