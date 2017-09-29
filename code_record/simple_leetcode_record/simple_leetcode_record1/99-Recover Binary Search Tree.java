/*Created by ${USER} on ${DATE}.
 *题意：恢复调换两个节点的二叉搜索树
 *注意：
 *思路：1.中序遍历树  正常情况 后面的要比前面的节点大 如果小 就出现问题了
 *        12345678 ———— 12375648  当第一次出现后面比前面大时 记录前面这个值，当第二次出现时记录后面这个值
 *        调换
 *      2. 用一个变量记录前一个值 pre第一次应该等于 最左下角的值
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次



//第二次
public class Solution {
    TreeNode first,last,pre;
    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp=last.val;
        last.val=first.val;
        first.val=temp;
    }
    public void inorder(TreeNode root){
        if(root.left!=null){
            inorder(root.left);
        }
        if(pre==null) pre=root;

        if(root.val<pre.val){
            if(first==null){
                first=pre;
            }
            last=root;
        }
        else pre=root;
        if(root.right!=null)
            inorder(root.right);
    }
}