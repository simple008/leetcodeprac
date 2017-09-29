/*Created by ${USER} on ${DATE}.
 *题意：把二叉树每层的链表从左到右连起来，每层最后一个的next置null
 *注意：
 *思路：层次遍历，记一个pre指针记录上一次访问的节点，如果访问的当前节点是本层的最后一个节点将它的下一个节点
 * 置空
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode prev=null;
        TreeLinkNode parent=root;
        TreeLinkNode next=null;
        while(parent!=null){
            while(parent!=null){
                if(parent.left!=null){
                    if(prev!=null){
                        prev.next=parent.left;
                    }
                    else {
                        next=parent.left;
                    }
                    prev=parent.left;
                }
                if(parent.right!=null){
                    if(prev!=null){
                        prev.next=parent.right;
                    }
                    else{
                        next=parent.right;
                    }
                    prev=parent.right;
                }
                parent=parent.next;
            }
            parent=next;
            next=null;
            prev=null;
        }
    }
}
//第二次
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        if(root==null) return ;
        queue.offer(root);
        int size=0;

        TreeLinkNode node=null;
        while(!queue.isEmpty()){
            size=queue.size();
            TreeLinkNode pre=null;
            for(int i=0;i<size;i++){
                node=queue.poll();
                if(pre==null){
                    pre=node;
                }else{
                    pre.next=node;
                    pre=node;
                }
                if(i==size-1){
                    node.next=null;
                    pre=null;
                }
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
    }
}