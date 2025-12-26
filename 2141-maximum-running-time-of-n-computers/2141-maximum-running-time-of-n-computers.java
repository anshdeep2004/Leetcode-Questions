class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        long left = 0;
        // int right = (int) 1e9;
        long totalEnergy = 0;
        for (int b : batteries) {
            totalEnergy += b;
        }

        long right = totalEnergy / n;
        long mid = 0;

        while(left <= right) {
            mid = left + (right - left) / 2;

            long totalBattery = 0;
            for(int i=0; i<len; i++) {
                totalBattery += Math.min(batteries[i], mid);
            }

            if(totalBattery >= n * mid) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return right;
    }
}