/*Created by ${USER} on ${DATE}.
 *题意：中序遍历 二叉树
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次   递归解法

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root==null) return ;
        if(root.left!=null)
        {
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null)
            inorder(root.right,list);
    }
}

// 第一次 非递归
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        // TreeNode root = root;

        while( !stack.isEmpty() || root!=null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            if( !stack.isEmpty()){
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }

        return list;
    }
}



//第二次   递归解法
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list){
        if(root.left!=null){
            inorder(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null)
            inorder(root.right,list);

    }
}


//非递归解法
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode node;

        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(!stack.isEmpty()){
                node=stack.pop();
                list.add(node.val);
                if(node.right!=null)
                    root=node.right;
            }
        }
        return list;
    }
}