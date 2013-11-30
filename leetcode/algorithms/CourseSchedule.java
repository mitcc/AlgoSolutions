/*
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it 
 * possible for you to finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0, and to take course 0 you should also have finished course 
 * 1. So it is impossible.
 * 
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not 
 * adjacency matrices. Read more about how a graph is represented.
 * 
 * click to show more hints.
 * 
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. 
 * If a cycle exists, no topological ordering exists and therefore it will be 
 * impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera 
 * explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 */
public class CourseSchedule {

    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            degree[prerequisites[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < degree.length; ++i) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int noPreCourseCount = queue.size();
        while (!queue.isEmpty()) {
            int top = queue.remove();
            for (int i = 0; i < prerequisites.length; ++i) {
                if (prerequisites[i][1] == top) {
                    degree[prerequisites[i][0]]--;
                    if (degree[prerequisites[i][0]] == 0) {
                        noPreCourseCount++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return noPreCourseCount == numCourses;
    }

/*****************************************************************************/

    // DFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = 
            new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; ++i) {
            if (map.containsKey(prerequisites[i][1])) {
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1], list);
            }
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (!canFinish(map, visited, i))
                return false;
        }
        return true;
    }

    public boolean canFinish(Map<Integer, List<Integer>> map, 
            int[] visited, int i) {
        if (visited[i] == -1)
            return false;
        if (visited[i] == 1)
            return true;
        visited[i] = -1;
        if (map.containsKey(i)) {
            for (int v : map.get(i)) {
                if (!canFinish(map, visited, v))
                    return false;
            }
        }
        visited[i] = 1;
        return true;
    }

}
