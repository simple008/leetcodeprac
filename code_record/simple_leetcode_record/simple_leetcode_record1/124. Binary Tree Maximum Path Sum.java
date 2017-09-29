/*Created by ${USER} on ${DATE}.
 *题意：从二叉树的任意节点开始到任意节点结束的路径最大和是多少
 *注意：
 *思路：分情况，可能左子树和是最大和，右子树和是最大和，左子树加右子树加根节点是最大和
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//first time
public class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root==null) return 0;
        int t=maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root==null) return 0;
        int temp=root.val;

        int left=maxSum(root.left);
        int right=maxSum(root.right);

        if(left>0) temp+=left;
        if(right>0) temp+=right;

        max=Math.max(temp,max);   //比较全局最大值

        return Math.max(0,Math.max(left,right))+root.val;   //当前分支的最大值，左边或者右边只能取一个返回上一层
    }
}

//第二次

public class Solution {
    int max = Integer.MIN_VALUE;    //最大值置为-max   处理最大和为负数的情况
    public int maxPathSum(TreeNode root) {
        int a = sum(root);
        return max;
    }
    public int sum(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(sum(root.left),0);   //可以处理左右分之小于0的情况舍去
        int right = Math.max(sum(root.right),0);

        max = Math.max(max,left+right+root.val);
        return root.val + Math.max(left,right);   //但是最终返回 root要考虑第一次就是负数不能舍去的情况
    }
}