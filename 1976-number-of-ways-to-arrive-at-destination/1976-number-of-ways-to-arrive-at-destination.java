class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        long[] time = new long[n];
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length; i++) {
            adj.get(roads[i][0]).add(new int[] {roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new int[] {roads[i][0], roads[i][2]});
        }
        for(int i=0; i<n; i++) {
            time[i] = Long.MAX_VALUE; 
        }
        // PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        PriorityQueue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        pq.offer(new long[] {0L, 0});
        time[0] = 0;
        int[] countWays = new int[n];
        countWays[0] = 1;
        while(!pq.isEmpty()) {
            long[] arr = pq.poll();
            int node = (int) arr[1];
            long timing = arr[0];
            for(int j=0; j<adj.get(node).size(); j++) {
                int adjNode = adj.get(node).get(j)[0];
                int currTime = adj.get(node).get(j)[1];
                if(timing + currTime < time[adjNode]) {
                    time[adjNode] = timing + currTime;
                    pq.offer(new long[] {time[adjNode], adjNode});
                    countWays[adjNode] = countWays[node];
                }
                else if(timing + currTime == time[adjNode]) {
                    countWays[adjNode] = (countWays[adjNode]  + countWays[node]) % MOD;
                }
            }
        }
        return countWays[n-1] % MOD;
    }
}