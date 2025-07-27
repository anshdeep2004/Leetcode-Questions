class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        int[] dist = new int[n];
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<flights.length; i++) {
            adj.get(flights[i][0]).add(new int[] {flights[i][1], flights[i][2]}); // {node, current distance}
        }
        for(int i=0; i<n; i++) {
            dist[i] = (int) 1e9;
        }
        Queue<int[]> que = new LinkedList<>();
        dist[src] = 0;
        que.offer(new int[] {0, src, 0}); // {stops, node, distance}
        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int stops = arr[0];
            int node = arr[1];
            int distance = arr[2];
            if(stops > k) continue;
            for(int j=0; j<adj.get(node).size(); j++) {
                int adjNode = adj.get(node).get(j)[0];
                int currDist = adj.get(node).get(j)[1];
                if(distance + currDist < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance + currDist;
                    que.offer(new int[] {stops + 1, adjNode, dist[adjNode]});
                }
            }
        }
        if(dist[dst] == (int) 1e9) return -1;
        return dist[dst];
    }
}