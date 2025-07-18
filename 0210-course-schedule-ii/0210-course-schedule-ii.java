class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        int[] result = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        for(int i=0; i<numCourses; i++) {
            if(inDegree[i] == 0) {
                que.offer(i);
            }
        }

        int j = 0;
        while(!que.isEmpty()) {
            int node = que.poll();
            result[j++] = node;
            for(int i : adj.get(node)) {
                inDegree[i]--;
                if(inDegree[i] == 0) {
                    que.offer(i);
                }
            }
        }
        return j == numCourses ? result : new int[] {};
    }
}