class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int [] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);
        HashMap<Integer, Integer> finalHash = new HashMap<>();
        int [] result = new int[k];
        for(int i=(n-k); i<n; i++) {
            finalHash.put(sortedNums[i], finalHash.getOrDefault(sortedNums[i], 0) + 1);
        }
        System.out.println(finalHash);
        int j = 0;
        for(int l=0; l<n; l++) {
            System.out.println(nums[l]);
            if(finalHash.containsKey(nums[l]) && finalHash.get(nums[l]) > 0) {
                finalHash.put(nums[l], finalHash.get(nums[l]) - 1);
                //System.out.println(num);
                result[j] = nums[l];
                j++;
            }
            if(j == k) {
                break;
            }
        }
        return result;
    }
}