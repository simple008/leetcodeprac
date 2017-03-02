/*Created by ${USER} on ${DATE}.
 *题意：判断是否是平衡二叉树树
 *注意：
 *思路：1. 定义  高度差不超过1
 *      2.递归判断当前高度是否 超过1  左右子树高度差是否超过1
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        int left=depth(root.left);
        int right=depth(root.right);
        return Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;

    }
}

//第二次
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int dep1=getDep(root.left);
        int dep2=getDep(root.right);
        return Math.abs(dep1-dep2)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int getDep(TreeNode root){
        if(root==null) return 0;

        return 1+Math.max(getDep(root.right),getDep(root.left));
    }
}