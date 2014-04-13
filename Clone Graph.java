/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null==node) return null;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        visited.put(node,new UndirectedGraphNode(node.label));
        dfs(node,visited);
        return visited.get(node);
    }
    
    public void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> visited){
        UndirectedGraphNode newnode = visited.get(node);
        for(UndirectedGraphNode neighbor:node.neighbors){
            if(!visited.containsKey(neighbor)){
                visited.put(neighbor,new UndirectedGraphNode(neighbor.label));
                dfs(neighbor,visited);
            }
            newnode.neighbors.add(visited.get(neighbor));
        }
    }
}
