/*Created by ${USER} on ${DATE}.
 *题意：计算完全二叉树的节点总数
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return 1;
        int height=0;
        int nodeSum=0;
        TreeNode cur=root;
        while(cur.left!=null){
            nodeSum+=(1<<height);
            height++;
            cur=cur.left;
        }
        return nodeSum+countLastLevel(root,height);
    }
    private int countLastLevel(TreeNode root,int height){
        if(height==1){
            if(root.right!=null) return 2;
            else if(root.left!=null) return 1;
            else return 0;}
        TreeNode midNode =root.left;
        int curHeight=1;
        while(curHeight<height){
            curHeight++;
            midNode =midNode.right;
        }
        if(midNode==null) return countLastLevel(root.left,height-1);
        else return (1<<(height-1))+countLastLevel(root.right,height-1);
    }
}