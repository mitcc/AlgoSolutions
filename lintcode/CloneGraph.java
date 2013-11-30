/*
 * Clone an undirected graph. Each node in the graph contains a label and a 
 * list of its neighbors.

How we serialize an undirected graph:

Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and 
each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as 
separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a 
self-cycle.
Visually, the graph looks like the following:

   1
  / \
 /   \
0 --- 2
     / \
     \_/
Example
return a deep copied graph.
 */
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; 
 *     neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    // DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = 
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, copy);
        while (!stack.isEmpty()) {
            UndirectedGraphNode cur = stack.pop();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    stack.push(neighbor);
                    UndirectedGraphNode copyNode = 
                        new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copyNode);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }

/*****************************************************************************/

    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = 
            new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = 
            new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, copy);
        while (queue.peek() != null) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    UndirectedGraphNode copyNode = 
                        new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copyNode);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return copy;
    }

}
