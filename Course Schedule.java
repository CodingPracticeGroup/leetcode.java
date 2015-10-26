public class Solution {
  private boolean canFinish_hasCycle(int numCourses, int[][] prerequisites, int i,
      Set<Integer> visited, Deque<Integer> path) {
    visited.add(i);
    path.offerLast(i);
    for (int m = 0; m < prerequisites.length; m++) {
      if (prerequisites[m][0] == i) {
        if (!visited.contains(prerequisites[m][1])) {
          if (canFinish_hasCycle(numCourses, prerequisites, prerequisites[m][1], visited, path))
            return true;
        } else {
          for (Integer n : path) {
            if (n == prerequisites[m][1])
              return true;
          }
        }
      }
    }
    path.pollLast();
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (!visited.contains(i)) {
        if (canFinish_hasCycle(numCourses, prerequisites, i, visited, new ArrayDeque<Integer>()))
          return false;
      }
    }
    return true;
  }
}
