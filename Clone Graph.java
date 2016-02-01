public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null)
      return null;
    Map<UndirectedGraphNode, UndirectedGraphNode> visited_map = new HashMap<>(); // mark
    Deque<UndirectedGraphNode> stack = new LinkedList<>(); // stack
    visited_map.put(node, new UndirectedGraphNode(node.label)); // mark
    stack.push(node); // push
    while (!stack.isEmpty()) {
      UndirectedGraphNode un = stack.pop(); // pop
      for (UndirectedGraphNode child : un.neighbors) { // neighbors
        if (!visited_map.containsKey(child)) { // prune
          visited_map.put(child, new UndirectedGraphNode(child.label)); // mark
          stack.push(child); // push
        }
        visited_map.get(un).neighbors.add(visited_map.get(child));
      }

    }
    return visited_map.get(node);
  }
}
----------
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }
    Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
    Deque<UndirectedGraphNode> queue = new ArrayDeque<>();
    visited.put(node, new UndirectedGraphNode(node.label));
    queue.offer(node);
    while (!queue.isEmpty()) {
      UndirectedGraphNode n = queue.poll();
      for (UndirectedGraphNode nn : n.neighbors) {
        if (!visited.containsKey(nn)) {
          visited.put(nn, new UndirectedGraphNode(nn.label));
          queue.offer(nn);
        }
        visited.get(n).neighbors.add(visited.get(nn));
      }
    }
    return visited.get(node);
  }
}