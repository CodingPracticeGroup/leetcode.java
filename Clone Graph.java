import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for undirected graph.
 */
class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};

public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		// Note: The Solution object is instantiated only once and is reused by each test case.
		HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		visited.put(node, new UndirectedGraphNode(node.label));
		dfs(visited.get(node), node, visited);
		return visited.get(node);
	}

	private void dfs(UndirectedGraphNode des, UndirectedGraphNode src,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
		for (UndirectedGraphNode node : src.neighbors) {
			if (!visited.containsKey(node)) {
				visited.put(node, new UndirectedGraphNode(node.label));
				dfs(visited.get(node), node, visited);
			}
		}
		for (UndirectedGraphNode node : src.neighbors) {
			des.neighbors.add(visited.get(node));
		}
	}
}