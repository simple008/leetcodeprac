/*Created by ${USER} on ${DATE}.
 *题意：二叉查找树最近公共祖先
 *注意：
 *思路：数值大小来判断
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a=0,b=0;
        if(p.val>q.val){
            a=p.val;
            b=q.val;
        }
        else {
            a=q.val;
            b=p.val;
        }
        return lowest(root,a,b);
    }
    public TreeNode lowest(TreeNode root,int a,int b){
        if(root.val>=b&&root.val<=a) return root;
        else if(root.val>a) return lowest(root.left,a,b);
        else return lowest(root.right,a,b);
        // return root;
    }
}

