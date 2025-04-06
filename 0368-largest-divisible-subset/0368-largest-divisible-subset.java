// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         int n = nums.length;
//         List<Integer> result = new ArrayList<>();
//         if(n == 0) {
//             return result;
//         }
//         if(n == 1) {
//             result.add(nums[0]);
//             return result;
//         }
//         Arrays.sort(nums);
//         List<Integer> tempResult = new ArrayList<>();

//         for(int i=0; i<n; i++) {
//             tempResult.add(nums[i]);
//             for(int j=i+1; j<n; j++) {
//                 if(nums[j] % tempResult.get(tempResult.size()-1) == 0) {
//                     tempResult.add(nums[j]);
//                 }
//             }
//             System.out.println(tempResult);
//             if(tempResult.size() > result.size()) {
//                 result = new ArrayList<>(tempResult);
//             }
//             tempResult.clear();
//         }
//         return result;
//     }
// }

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        int[] prev = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int maxi = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxi]) maxi = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = maxi; i >= 0; i = prev[i]) {
            res.add(nums[i]);
        }
        return res;
    }
}