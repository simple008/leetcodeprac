/*Created by ${USER} on ${DATE}.
 *题意：克隆一个无向图，各数值按列表给出，#来区分不同的节点，“，”区分相邻节点
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return node;
        HashMap<Integer,UndirectedGraphNode> map=new HashMap<>();
        Queue<UndirectedGraphNode> queue=new LinkedList<>();
        queue.offer(node);
        map.put(node.label,new UndirectedGraphNode(node.label));

        while(!queue.isEmpty()){
            UndirectedGraphNode oldNode=queue.poll();
            for(UndirectedGraphNode noden: oldNode.neighbors){
                if(!map.containsKey(noden.label)){
                    queue.offer(noden);
                    map.put(noden.label,new UndirectedGraphNode(noden.label));
                }
                map.get(oldNode.label).neighbors.add(map.get(noden.label));
            }
        }
        return map.get(node.label);

    }
}
