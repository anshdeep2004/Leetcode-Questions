// class Solution {
//     public int countLargestGroup(int n) {
//         while(n / 10 != 0) {
//             int num = n;
//             int rem = 0;
//             int sum = 0;
//             while(num != 0) {
//                 rem = num % 10;
//                 sum += rem;
//                 num /= 10;
//             }
//             n = sum;
//         }
//         return n;
//     }
// }

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0, count = 0;

        for (int i = 1; i <= n; i++) {
            int x = digsum(i);
            mpp.put(x, mpp.getOrDefault(x, 0) + 1);
            maxi = Math.max(maxi, mpp.get(x));
        }

        for (int val : mpp.values()) if (val == maxi) count++;
        return count;
    }

    private int digsum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}