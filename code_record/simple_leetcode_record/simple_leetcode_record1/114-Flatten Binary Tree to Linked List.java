/*Created by ${USER} on ${DATE}.
 *题意：把二叉树展开成一个链表 只有又节点
 *注意：
 *思路：1. 先遍历右子树 找到逻辑最右节点 一次向上推  右根左的顺序
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次



//第二次
public class Solution {
    TreeNode pre=null;
    public void flatten(TreeNode root) {
        if(root==null) return ;
        flatten(root.right);
        flatten(root.left);
        root.right=pre;
        root.left=null;
        pre=root;
    }
}