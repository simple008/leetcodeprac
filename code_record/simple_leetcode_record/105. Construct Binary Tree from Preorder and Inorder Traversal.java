/*Created by ${USER} on ${DATE}.
 *题意：通过先序和中序 还原二叉树
 *注意：
 *思路：通过先序可以依次找到根节点  通过找到的根节点可以在中序中找到左右子树的范围 通过左右子树的范围继续递归找下一层
 *     1.中序确定的起止范围比较简单 就是 start~-1  i+1~end
 *     2.但是右子树的根节点在先序中的位置要注意  找的是同层的 比如
 *          原1234567 先1245367 中4251637 第二层左节点是2  右节点是3  在先序中的索引分别是1 4 而不是 1 2
 *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 * 递归时  参数有加减的 如 i+1 index-1  出口条件都会有这个start>end类似这种的范围条件
 * 通过数字的范围来确定是否有效
 */

//第一次
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,preorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int prestart,int instart,int inend,int[] preorder,int[]inorder){
        if(prestart>preorder.length-1||instart>inend) return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int index=0;
        for(int i=instart;i<=inend;i++){
            if(root.val==inorder[i])
                index=i;
        }
        root.left=helper(prestart+1,instart,index-1,preorder,inorder);
        root.right=helper(prestart+index-instart+1,index+1,inend,preorder,inorder);
        return root;

    }
}
//第二次

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return help(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode  help(int []preorder,int[] inorder,int index,int start,int end){
        if(index>=preorder.length||start>end) return null;
        TreeNode root=new TreeNode(preorder[index]);
        int a=0;
        for(int i=start;i<=end;i++){
            if(inorder[i]==preorder[index]){
                a=i;
            }
        }
        TreeNode lTree=help(preorder,inorder,index+1,start,a-1);
        TreeNode rTree=help(preorder,inorder,index+a-start+1,a+1,end);
        root.left=lTree;
        root.right=rTree;
        return root;

    }
}