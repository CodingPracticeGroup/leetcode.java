Course Schedule IIpublic class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> id_outedge = new HashMap<>();
    Map<Integer, Integer> id_indegree = new HashMap<>();
    Set<Integer> indegree_0 = new HashSet<>();

    for (int[] pair : prerequisites) {
      if (!id_outedge.containsKey(pair[1]))
        id_outedge.put(pair[1], new HashSet<>());
      if (!id_outedge.get(pair[1]).contains(pair[0])) { // new edge
        id_outedge.get(pair[1]).add(pair[0]);

        if (!id_indegree.containsKey(pair[0]))
          id_indegree.put(pair[0], 0);
        id_indegree.put(pair[0], id_indegree.get(pair[0]) + 1);
      }
    }
    for (int i = 0; i < numCourses; i++) {
      if (!id_indegree.containsKey(i))
        indegree_0.add(i);
    }

    List<Integer> ret = new ArrayList<>();
    while (!indegree_0.isEmpty()) {
      Iterator<Integer> it = indegree_0.iterator();
      Integer node = it.next();
      it.remove();
      ret.add(node);

      if (id_outedge.containsKey(node)) {
        for (Integer peer : id_outedge.get(node)) {
          id_indegree.put(peer, id_indegree.get(peer) - 1);
          if (id_indegree.get(peer) == 0) {
            id_indegree.remove(peer);
            indegree_0.add(peer);
          }
        }
        id_outedge.remove(node);
      }
    }

    if (id_outedge.isEmpty())
      return ret.stream().mapToInt(x -> x).toArray();
    else
      return new int[0];
  }
}
--------------------------
public class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int indegree[] = new int[numCourses]; // indegree==0: leaf
    Arrays.fill(indegree, 0);
    Map<Integer, Set<Integer>> parents = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      parents.put(i, new HashSet<Integer>());
    }
    for (int[] e : prerequisites) {
      if (parents.get(e[1]).add(e[0])) { // duplicates
        indegree[e[0]]++;
      }
    }

    int[] ret = new int[numCourses];
    int idx = 0;
    Deque<Integer> queue = new ArrayDeque<>(); // bfs: leaf->root
    queue.addAll(IntStream.range(0, numCourses).filter(x -> indegree[x] == 0).boxed()
        .collect(Collectors.toSet()));
    while (!queue.isEmpty()) {
      int node = queue.poll();
      ret[idx++] = node; // topo order
      for (Integer i : parents.get(node)) {
        indegree[i]--;
        if (indegree[i] == 0) { // mark
          queue.offer(i);
        }
      }
    }
    if (IntStream.range(0, numCourses).filter(x -> indegree[x] == 0).count() != numCourses) { // cycle
      return new int[] {};
    }
    for (int i = 0; i < numCourses; i++) { // islands
      if (!parents.containsKey(i)) {
        ret[idx++] = i;
      }
    }
    return ret;
  }
}
