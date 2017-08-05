/*Created by ${USER} on ${DATE}.
 *���⣺��¡һ������ͼ������ֵ���б������#�����ֲ�ͬ�Ľڵ㣬�������������ڽڵ�
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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
