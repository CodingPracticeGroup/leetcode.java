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
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] in = new int[numCourses]; // in degree
    Arrays.fill(in, 0);

    Map<Integer, Set<Integer>> g = new HashMap<>(); // graph
    for (int i = 0; i < numCourses; i++) {
      g.put(i, new HashSet<Integer>());
    }
    for (int[] e : prerequisites) {
      if (g.get(e[0]).add(e[1])) { // duplicates
        in[e[1]]++;
      }
    }

    Deque<Integer> q = new ArrayDeque<>(); // leaf
    for (int i = 0; i < numCourses; i++) {
      if (in[i] == 0) {
        q.offer(i);
      }
    }
    while (!q.isEmpty()) {
      int node = q.poll(); // cut leaf
      for (Integer peer : g.get(node)) {
        in[peer]--;
        if (in[peer] == 0) {
          q.offer(peer);
        }
      }
    }

    for (int i = 0; i < numCourses; i++) {
      if (in[i] > 0) {
        return false;
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
--------------
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> g = new HashMap<>(); // 邻接链表，等同于int[][] prerequisites，只读
    for (int i = 0; i < numCourses; i++) {
      g.put(i, new HashSet<Integer>());
    }
    for (int[] e : prerequisites) {
      g.get(e[0]).add(e[1]); // duplicates
    }

    boolean visited[] = new boolean[numCourses]; // mark
    Arrays.fill(visited, false);
    for (int i = 0; i < numCourses; i++) { // forest
      if (visited[i]) {
        continue;
      }

      Deque<Integer> path = new ArrayDeque<>(); // stack
      visited[i] = true; // mark
      path.push(i); // push
      while (!path.isEmpty()) {
        int node = path.peek(); // path
        boolean pop = true;
        for (Integer p : g.get(node)) {
          if (!visited[p]) { // prune
            visited[p] = true; // mark
            path.push(p); // push
            pop = false;
          } else { // cycle
            for (Integer j : path) {
              if (j == p) {
                return false;
              }
            }
          }
        }
        if (pop) { // pop
          path.pop();
        }
      }
    }
    return true;
  }
}
------------------
public class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses]; // 入度为0的就是叶子；这个数组才是关键，因为adj是单向的，被这个数组一卡，就能截出叶子
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    for (int[] e : prerequisites) {
      if (adj.computeIfAbsent(e[0], x -> new HashSet<Integer>()).add(e[1])) { // 去重复
        inDegree[e[1]]++;
      }
    }
    LinkedList<Integer> leaf = new LinkedList<>(IntStream.range(0, numCourses)
        .filter(x -> inDegree[x] == 0).boxed().collect(Collectors.toList()));
    while (!leaf.isEmpty()) {
      int i = leaf.poll();
      if (adj.containsKey(i)) { // 因为adj不一定包含所有的点，所以要判断一下；或者前面adj做成包含所有点的，这里就不用判断
        for (Integer peer : adj.get(i)) {
          inDegree[peer]--;
          if (inDegree[peer] == 0) { // 找下一个叶子
            leaf.offer(peer);
          }
        }
        adj.remove(i); // 去掉叶子
      }
    }
    return adj.isEmpty();
  }
}
