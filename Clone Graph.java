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
