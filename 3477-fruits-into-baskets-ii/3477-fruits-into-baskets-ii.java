class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int f = fruits.length;
        int b = baskets.length;
        int[] marked = new int[b];
        int unplaced = f;
        for(int i=0; i<f; i++) {
            for(int j=0; j<b; j++) {
                if(baskets[j] >= fruits[i]&& marked[j] != 1) {
                    marked[j] = 1;
                    unplaced--;
                    break;
                }
            }
        }
        return unplaced;
    }
}