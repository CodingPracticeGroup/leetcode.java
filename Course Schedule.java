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
----------------
/*******************
cannot pass large test
*******************/
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> m = new HashMap<>();
    for (int[] a : prerequisites) {
      if (!m.containsKey(a[0])) {
        m.put(a[0], new HashSet<Integer>());
      }
      m.get(a[0]).add(a[1]);
    }

    while (!m.isEmpty()) {
      Set<Integer> nodes = m.keySet().stream().filter(i -> {
        for (Set<Integer> ss : m.values()) {
          if (ss.contains(i)) {
            return false;
          }
        }
        return true;
      }).collect(Collectors.toSet());
      if (nodes.isEmpty()) {
        return false;
      } else {
        for (Integer h : nodes) {
          m.remove(h);
        }
      }
    }

    return true;
  }
}
----------------
public class Solution {
  private boolean hascycle(int num, int[][] pre, int cur, Deque<Integer> path,
      Set<Integer> visited) {
    visited.add(cur);
    path.push(cur);
    for (int[] p : pre) {
      if (p[0] == cur) {
        if (!visited.contains(p[1])) {
          if (hascycle(num, pre, p[1], path, visited)) {
            return true;
          }
        } else {
          for (Integer i : path) {
            if (p[1] == i) {
              return true;
            }
          }
        }
      }
    }
    path.pop();
    return false;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Set<Integer> visited = new HashSet<>();
    for (int i = 0; i < numCourses; i++) {
      if (!visited.contains(i)) {
        if (hascycle(numCourses, prerequisites, i, new ArrayDeque<Integer>(), visited)) {
          return false;
        }
      }
    }
    return true;
  }
}
