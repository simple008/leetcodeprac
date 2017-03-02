/*Created by ${USER} on ${DATE}.
 *题意:以Z型层次遍历二叉树
 *注意：
 *思路：两个栈  循环遍历  第一个栈先入 左节点 第二个栈先入右节点
 *一刷： 子while循环内 嵌套for循环注意size变量的定义
 *二刷：每个子while循环 结束后都要判断list是否为空  并且清空 list作为下一个子while循环使用
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list_out=new ArrayList<List<Integer>>();
        if(root==null) return list_out;
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty()||!stack2.isEmpty()){

            while(!stack1.isEmpty()){
                List<Integer> list=new ArrayList<Integer>();
                int size=stack1.size();
                for(int i=0;i<size;i++){
                    TreeNode temp=stack1.pop();
                    list.add(temp.val);
                    //   if(temp==null) break;
                    if(temp.left!=null)
                        stack2.push(temp.left);
                    if(temp.right!=null)
                        stack2.push(temp.right);
                }
                list_out.add(new ArrayList(list));
            }
            while(!stack2.isEmpty()){
                List<Integer> list1=new ArrayList<Integer>();
                int size=stack2.size();
                for(int i=0;i<size;i++){
                    TreeNode temp=stack2.pop();
                    //   if(temp==null) break;
                    list1.add(temp.val);
                    if(temp.right!=null)
                        stack1.push(temp.right);
                    if(temp.left!=null)
                        stack1.push(temp.left);
                }
                list_out.add(new ArrayList(list1));
            }
        }
        return list_out;
    }
}

// 第二次
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack1=new Stack<TreeNode>();
        Stack<TreeNode> stack2=new Stack<TreeNode>();
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null) return list;
        stack1.push(root);
        TreeNode node=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()){
            List<Integer> li=new ArrayList<Integer>();
            while(!stack1.isEmpty()){
                node=stack1.pop();
                li.add(node.val);
                if(node.left!=null)
                    stack2.push(node.left);
                if(node.right!=null)
                    stack2.push(node.right);
            }
            if(li.size()!=0)
                list.add(new ArrayList<Integer>(li));
            li.clear();
            while(!stack2.isEmpty()){
                node=stack2.pop();
                li.add(node.val);
                if(node.right!=null)
                    stack1.push(node.right);
                if(node.left!=null)
                    stack1.push(node.left);
            }
            if(li.size()!=0)
                list.add(new ArrayList<Integer>(li));
        }
        return list;
    }
}
