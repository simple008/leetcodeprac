/*Created by ${USER} on ${DATE}.
 *题意：后序遍历二叉树
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
// 第一次
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                list.addFirst(root.val);
                root = root.right;  //按照根右左的顺序栈  列表往前加 变成 左右根的链表顺序
            }

            if( !stack.isEmpty()){

                root = stack.pop();

                root = root.left;
            }
        }

        return list;
    }
}
//第二次
//递归
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
//非递归  用根右左的方法来遍历 list.add(index,val);
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