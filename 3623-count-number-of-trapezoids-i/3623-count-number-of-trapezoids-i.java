// class Solution {
//     public int countTrapezoids(int[][] points) {
//         long Mod = 1000000000L + 7;
//         int n = points.length;
//         HashMap<Integer, Integer> yCount = new HashMap<>();

//         for(int i=0; i<n; i++) {
//             int tempY = points[i][1];
//             int yFreq = yCount.getOrDefault(tempY, 0);
//             yCount.put(tempY, yFreq + 1);
//         }

//         long ySum = 0;
//         long ySqSum = 0;
//         for(Map.Entry<Integer, Integer> map : yCount.entrySet()) {
//             int numYLevel = map.getValue();
//             int k = numYLevel * (numYLevel - 1) / 2; // ways to select 2 points of ith Y level.
//             ySum = (ySum + k) % Mod;
//             ySqSum = (ySqSum + k*k) % Mod;
//         }

//         long ans = (ySum*ySum - ySqSum) % Mod;

//         if(ans < 0) ans += Mod;

//         ans /= 2;

//         return (int) (ans % Mod);
//     }
// }

class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;

        HashMap<Integer, Integer> yCount = new HashMap<>();
        for (int[] p : points) {
            yCount.put(p[1], yCount.getOrDefault(p[1], 0) + 1);
        }

        long ySum = 0;
        long ySqSum = 0;

        for (int freq : yCount.values()) {
            if (freq >= 2) {
                long k = (long) freq * (freq - 1) / 2; // C(freq, 2)
                ySum = (ySum + k) % MOD;
                ySqSum = (ySqSum + k * k) % MOD;
            }
        }

        long ans = (ySum * ySum - ySqSum) % MOD;

        // divide by 2 using modular inverse
        ans = ans * ((MOD + 1) / 2) % MOD;

        return (int) ans;
    }
}