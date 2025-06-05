class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(asteroids[i] > 0) {
                result.add(asteroids[i]);
            }
            else {
                // colloids happen between more powerfull negative and less powerfull positive asteroids.
                while(!result.isEmpty() && result.get(result.size() - 1) > 0 && result.get(result.size() - 1) < Math.abs(asteroids[i])) {
                    result.remove(result.size() - 1);
                }

                // colloids happen between same powered positive and negative asteroids.
                if(!result.isEmpty() && result.get(result.size() - 1) == Math.abs(asteroids[i])) {
                    result.remove(result.size() -1);
                }

                // handling the negative asteroids when no positive asteroids are present.
                else if(result.isEmpty() || result.get(result.size() - 1) < 0) {
                    result.add(asteroids[i]);
                }
                else {
                    // nothing
                }
            }
        }
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}