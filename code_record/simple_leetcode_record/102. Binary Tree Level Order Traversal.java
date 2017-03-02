/*Created by ${USER} on ${DATE}.
 *题意：层次遍历 二叉树
 *注意：
 *思路：取一个队列记录  根据当前队列的大小 确定队列弹出元素的次数  这个大小要在for循环外定义 否则在循环内如队列的元素会对循环次数造成干扰
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次


//第二次

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null) return list;
        queue.offer(root);
        TreeNode node;
        while(!queue.isEmpty()){
            List<Integer> li=new ArrayList<Integer>();
            int len=queue.size();                       //这个定义一定要在for循环外定义
            for(int i=0;i<len;i++){
                node=queue.poll();
                li.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            list.add(new ArrayList<Integer>(li));
        }
        return list;
    }
}