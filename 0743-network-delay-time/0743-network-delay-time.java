class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        for(int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length; i++) {
            adj.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        for(int i=1; i<=n; i++) {
            dist[i] = (int) 1e9;
        }
        dist[k] = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        que.offer(new int[] {0, k});
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int sigTime = arr[0];
            int node = arr[1];
            for(int i=0; i<adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i)[0];
                int currSig = adj.get(node).get(i)[1];
                if(sigTime + currSig < dist[adjNode]) {
                    dist[adjNode] = sigTime + currSig;
                    que.offer(new int[] {dist[adjNode], adjNode});
                }
            }
        }
        int maxSigTime = 0;
        for(int i=1; i<=n; i++) {
            if(dist[i] == (int) 1e9) return -1;
            maxSigTime = Math.max(maxSigTime, dist[i]);
        }
        return maxSigTime;
    }
}