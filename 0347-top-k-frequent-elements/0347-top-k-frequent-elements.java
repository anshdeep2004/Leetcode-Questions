class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count the frequencies of each number
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets for frequencies
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Step 3: Fill the buckets
        for (HashMap.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            buckets[freq].add(num);
        }

        // Step 4: Collect the top k elements
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            for (int num : buckets[i]) {
                result.add(num);
                if (result.size() == k) {
                    break;
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = result.get(i);
        }

        return topK;
    }
}