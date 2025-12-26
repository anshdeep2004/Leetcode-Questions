// To run all n computers for T minutes:

// Total energy required = n × T

// Each battery can contribute at most min(battery[i], T) minutes

// Why min(battery[i], T)?

// A battery cannot be used for more than T minutes overall

// Even if a battery has more energy, it can only power one computer at a time

// Feasibility Condition

// For a given time T, check:
// 	​sum(min(battery[i], t)) >= n * T

// If this is true → it is possible to run all computers for T minutes
// If false → not possible

// This is the core condition of the entire problem.

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        long left = 0;
        // int right = (int) 1e9; ---> this is not good for complexity. Below is a better method.
        // upper bound will be sum(Batteries)/n as we cannot run the n computers more than average time for each computer.
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