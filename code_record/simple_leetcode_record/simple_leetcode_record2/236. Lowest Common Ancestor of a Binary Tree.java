/*Created by ${USER} on ${DATE}.
 *题意：二叉树的最近公共祖先
 *注意：
 *思路：递归  先判断本身节点是不是  目标节点  再指定一个left right 判断是不是Null  或者目标节点
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return root;
        if(root== p || root ==q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        if((left == p && right ==q) || (left == q && right ==p))
            return root;
        if(left != null)
            return left;
        else
            return right;
    }
}