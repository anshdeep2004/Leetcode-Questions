class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length;

        int totalApples = Arrays.stream(apple).sum();

        Arrays.sort(capacity);

        int ans = 0;

        for(int i=m-1; i>=0; i--) {
            if(totalApples <= 0) break;

            totalApples -= capacity[i];
            ans++;
        }

        return ans;
    }
}