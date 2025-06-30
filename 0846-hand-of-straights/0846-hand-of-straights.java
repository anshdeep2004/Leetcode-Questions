class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i=0; i<n; i++) {
            tm.put(hand[i], tm.getOrDefault(hand[i], 0) + 1);
        }
        while(!tm.isEmpty()) {
            int limit = 0;
            for(Map.Entry<Integer, Integer> map : tm.entrySet()) {
                if( limit == groupSize) break;
                int key = map.getKey();
                int val = map.getValue();
                tm.put(key, tm.get(key) - 1);
                limit++;
            }
            Iterator<Map.Entry<Integer, Integer>> iterator = tm.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == 0) {
                    iterator.remove();  // Safely removes the entry
                }
            }
            if(tm.size() < groupSize && !tm.isEmpty()) return false;
        }
        return true;
    }
}