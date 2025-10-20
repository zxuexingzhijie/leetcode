import java.util.*;

public class problem49 {
    public static void main(String[] args) {
        Solution49 solution50 = new Solution49();

        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        System.out.println(solution50.canFinish(numCourses, prerequisites));
    }
}

class Solution49 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            graph.computeIfAbsent(pre, k-> new ArrayList<>()).add(course);
            //查看前置课程，如果有前置课程，则+1
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited++;
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return visited == numCourses;
    }
}
