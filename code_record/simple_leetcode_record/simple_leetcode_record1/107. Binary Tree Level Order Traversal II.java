/*Created by ${USER} on ${DATE}.
 *题意：从下向上层次遍历二叉树
 *注意：
 *思路：跟从下到上一样  在插入list时每次都插到最前面
 *一刷：把层次遍历的每个子列表放到栈里 最后遍历栈 弹出
 *二刷：ok  向母列表中插入子列表时每次都插到最前面
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> li=new ArrayList<List<Integer>>();

        // Stack<List<Integer>> stack=new Stack
        Stack<List<Integer>> stack =new Stack<List<Integer>>();
        if (root==null)  return li;
        // List <Integer> liin=new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()){

            List <Integer> lin=new ArrayList<Integer>();
            int j=queue.size();
            for(int i=0;i<j;i++ ){

                TreeNode node=queue.remove();

                lin.add(node.val);
                if(node.left!=null)
                    queue.add(node.left);
                // queue.enqueue(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                // queue.enqueue(node.right);
            }
            stack.push(lin);
            // lin.clear();
        }
        while(!stack.isEmpty())
        {
            li.add(stack.peek());
            stack.pop();
        }
        return li;
    }
}



//第二次
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            list.add(0,new ArrayList<Integer>(li));
        }
        return list;
    }
}