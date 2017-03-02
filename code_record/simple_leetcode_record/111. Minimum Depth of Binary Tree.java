/*Created by ${USER} on ${DATE}.
 *题意：二叉树的最小深度
 *注意：
 *思路：递归   分情况：节点为空  节点不全为空（分支的最大值） 节点都不空（分支的最小值）
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public int minDepth(TreeNode root) {
        if( root==null)
        {return 0;}
        if(root.left!=null&&root.right!=null)
            return Math.min(minDepth(root.left),minDepth(root.right))+1;
        else return Math.max(minDepth(root.left),minDepth(root.right))+1;
    }
}


//第二次
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;

        if(root.left!=null&&root.right!=null)
            return (1+Math.min(minDepth(root.left),minDepth(root.right)));
        else return (1+Math.max(minDepth(root.left),minDepth(root.right)));
    }

}

public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left!=null&&root.right!=null)
            return (1+Math.min(minDepth(root.left),minDepth(root.right)));
        else return (1+Math.max(minDepth(root.left),minDepth(root.right)));
    }

}