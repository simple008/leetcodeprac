/*Created by ${USER} on ${DATE}.
 *���⣺ʵ��һ��iterator  ���Է���һ���������������һ���ڵ㣬�Լ��ж��Ƿ������һ���ڵ�
 *ע�⣺
 *˼·��
 *һˢ����������������ŵ�������
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��
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