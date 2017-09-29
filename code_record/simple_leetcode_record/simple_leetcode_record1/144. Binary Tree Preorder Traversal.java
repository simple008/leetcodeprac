/*Created by ${USER} on ${DATE}.
 *题意： 前序遍历二叉树
 *注意：
 *思路：
 *一刷：
 *二刷：注意 root==null 的返回条件
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while( !stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }

            if( !stack.isEmpty()){
                root = stack.pop();
                // list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }
}
// 递归
public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {

        preorder(root);
        return list;
    }
    public void preorder(TreeNode root){
        if(root == null)
            return ;
        list.add(root.val);

        if(root.left != null)
            preorder(root.left);
        if(root.right != null)
            preorder(root.right);
    }
}
//非递归 注意条件
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list =new ArrayList<Integer>();
        while(root != null){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            while(!stack.isEmpty() && root == null){
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }
}