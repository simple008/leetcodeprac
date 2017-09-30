/*Created by ${USER} on ${DATE}.
 *题意：找出二叉搜索树中的第k小的数
 *注意：
 *思路：递归 指定一个k  记录两个全局变量 m目标节点  i 次数
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    int m;
    int i=0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(k,root);
        return m;

    }
    public void inorder(int k,TreeNode root){
        if(i>=k)return ;
        // if(root==null) return ;
        if(root.left!=null) inorder(k,root.left);
        i++;
        if(i==k){
            m=root.val;
            return ;
        }
        if(root.right!=null){
            inorder(k,root.right);}
    }
}
//第二次
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        int[] tmp = {k};
        return inorder(root,tmp);
    }
}
TreeNode  inorder(TreeNode root, int[] k){
    TreeNode node = null;
    if(root.left != null)
        node = inorder(root,k);
    if(node ==null) {
        if (k[0] == 0) {
            node = root;
            return node;
        } else {
            k[0]--;
        }
    }
    if(node == null && root.right != null)
    node = inorder(root.right,k);
    return node;

}

//jianzhioffer 必须要用 引用变量 因为 遍历过得要计数，如果只用int  那么左子树遍历过的 回来之后 又恢复了 没起作用
public static TreeNode kthNode(BinaryTreeNode root, int k) {
    if (root == null || k < 1) {
        return null;
    }
    int[] tmp = {k};
    return kthNodeCore(root, tmp);
}
    private static TreeNode kthNodeCore(TreeNode root, int[] k) {
        TreeNode result = null;
        // 先成左子树中找
        if (root.left != null) {
            result =  kthNodeCore(root.left, k);
        }
        // 如果在左子树中没有找到
        if (result == null) {
            // 说明当前的根结点是所要找的结点
            if(k[0] == 1) {
                result = root;
            } else {
                // 当前的根结点不是要找的结点，但是已经找过了，所以计数器减一
                k[0]--;
            }
        }
        // 根结点以及根结点的右子结点都没有找到，则找其右子树
        if (result == null && root.right != null) {
            result = kthNodeCore(root.right, k);
        }
        return result;
    }


