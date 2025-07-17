class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // The approach to this question is that we know that this is making a directed graph type of a thing. So the simple solution would be that it is making a cycle if the tasks are impossible to perform and if there is no cycle then thats possible to do these tasks and return the order.
        // Step 1: Build the graph and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        // Step 2: Initialize the queue with all courses having in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Topological Sort using BFS
        int[] order = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[idx++] = course;

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check if we could schedule all courses
        return idx == numCourses ? order : new int[0];
    }
}