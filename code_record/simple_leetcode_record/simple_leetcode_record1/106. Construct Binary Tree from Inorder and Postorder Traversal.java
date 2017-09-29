/*Created by ${USER} on ${DATE}.
 *题意：根据中序和后序 还原二叉树
 *注意：
 *思路：根据后序 从后向前可以确定二叉树的根节点 一次前推 注意每次的范围
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return conTree(inorder,postorder,0,0,inorder.length-1,postorder.length-1);
    }
    public TreeNode conTree(int[] inorder,int[] postorder,int instart,int poststart,int inend,int postend){
        if (instart > inend) {
            return null;
        }
        int index=0;
        TreeNode root=new TreeNode(postorder[postend]);
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==root.val)
                index=i;
        }
        root.right=conTree(inorder,postorder,index+1,poststart+index-instart,inend,postend-1);
        root.left=conTree(inorder,postorder,instart,poststart,index-1,poststart+index-instart-1);
        return root;
    }
}

//第二次
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return help(inorder,postorder,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode help(int[]inorder,int[]postorder,int index,int start,int end){
        if(index<0||start>end) return null;
        int a=0;
        TreeNode root=new TreeNode(postorder[index]);
        for(int i=start;i<=end;i++){
            if(inorder[i]==postorder[index]){
                a=i;
            }
        }
        root.left=help(inorder,postorder,index-end+a-1,start,a-1);
        root.right=help(inorder,postorder,index-1,a+1,end);
        return root;
    }
}