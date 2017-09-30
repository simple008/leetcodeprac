/*Created by ${USER} on ${DATE}.
 *题意：把数的左右节点交换，
 *注意：
 *思路：递归解决就可以了
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode tmp=null;
        if(root==null) return root;
        tmp=root.left;
        root.left=root.right;
        root.right=tmp;

        TreeNode a = invertTree(root.left);
        TreeNode b = invertTree(root.right);

        return root;
    }
}