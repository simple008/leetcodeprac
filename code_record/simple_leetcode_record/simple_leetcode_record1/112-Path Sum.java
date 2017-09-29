/*Created by ${USER} on ${DATE}.
 *题意：判断是否存在一条路径 从根节点到叶子节点的累加和等于给定值
 *注意：
 *思路：每次加上当前根节点的值 判断是否是叶子是否符合规定  否则继续递归下面
 *一刷：麻烦
 *二刷：递归  cnt的累加 在判断根节点不是空之后 否则报异常
 *复杂度分析：
 *反思：
 *
 * 递归返回值 为boolean的 处理
 * 递归为int的返回值的处理
 */

//第一次
public class Solution {
    int sumn=0;
    int value=0;
    public boolean hasPathSum(TreeNode root, int sum) {
        sumn=sum;
        if(root==null) return false;
        return preorder(root);
    }
    public boolean preorder(TreeNode root){
        value+=root.val;
        boolean b=false;
        if(root.left==null&&root.right==null)
        {if(value==sumn) b= true;
        }
        else if(root.left==null&&root.right!=null)
            b=  preorder(root.right);
        else if (root.left!=null&&root.right==null)
            b= preorder(root.left);
        else b= preorder(root.left)||preorder(root.right);
        value-=root.val;
        return b;

    }
}
//第二次
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        return Sum(sum,root,0);
    }
    public boolean Sum(int sum,TreeNode root,int cnt){

        if(root==null) return false;
        cnt+=root.val;
        if(root.left==null&&root.right==null) return cnt==sum;

        return Sum(sum,root.left,cnt)||Sum(sum,root.right,cnt);

    }
}