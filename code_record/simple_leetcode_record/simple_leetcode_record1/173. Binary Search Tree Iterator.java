/*Created by ${USER} on ${DATE}.
 *题意：实现一个iterator  可以返回一个二叉查找树的下一个节点，以及判断是否存在下一个节点
 *注意：
 *思路：
 *一刷：中序遍历二叉树放到队列中
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class BSTIterator {
    Queue<Integer> queue=new LinkedList<Integer>();
    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(hasNext())
            return queue.poll();
        return 0;
    }
    public void inorder(TreeNode root){
        if(root==null) return ;
        if(root.left!=null)
            inorder(root.left);
        queue.add(root.val);
        if(root.right!=null)
            inorder(root.right);

    }
}

//
public class BSTIterator {
    Queue<Integer> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        queue = new LinkedList<>();
        inorder(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    public void inorder(TreeNode root){
        if(root == null) return ;
        inorder(root.left);
        queue.offer(root.val);
        inorder(root.right);
    }
}