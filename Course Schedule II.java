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