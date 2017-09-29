/*Created by ${USER} on ${DATE}.
 *题意：求树的最大高度
 *注意：
 *思路：当前树的最大高度=1+max(左右子树最大高度)
 *      null 返回0
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}
//第二次
public class Solution {
    public int maxDepth(TreeNode root) {
        return getMax(root);
    }
    public int getMax(TreeNode root){
        if(root!=null){
            return (1+Math.max(getMax(root.left),getMax(root.right)));
        }
        return 0;
    }
}