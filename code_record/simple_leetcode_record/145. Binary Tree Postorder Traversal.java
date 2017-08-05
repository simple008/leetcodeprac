/*Created by ${USER} on ${DATE}.
 *���⣺�������������
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
// ��һ��
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                list.addFirst(root.val);
                root = root.right;  //���ո������˳��ջ  �б���ǰ�� ��� ���Ҹ�������˳��
            }

            if( !stack.isEmpty()){

                root = stack.pop();

                root = root.left;
            }
        }

        return list;
    }
}
//�ڶ���
//�ݹ�
public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        postorder(root);
        return list;

    }
    public void postorder(TreeNode root){
        if(root ==null){
            return ;
        }
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);

    }
}
//�ǵݹ�  �ø�����ķ��������� list.add(index,val);
public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root!=null){
            while(root!=null){
                stack.push(root);
                list.add(0,root.val);
                root = root.right;
            }
            while(root == null && !stack.isEmpty()){
                root = stack.pop();
                root = root.left;
            }
        }
        return list;
    }
}
public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return list;
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(0,root.val);
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);
        }
        return list;
    }
}