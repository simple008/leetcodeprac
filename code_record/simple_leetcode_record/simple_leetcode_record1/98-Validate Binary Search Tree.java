/*Created by ${USER} on ${DATE}.
 *题意：判断一棵二叉树是否是有效的二叉查找树
 *注意：
 *思路：
 *一刷：先中序遍历  把节点都放到列表中 然后遍历列表 判断是否严格升序
 *二刷：递归判断
 *复杂度分析：
 *反思：
 */

//第一次

public class Solution {
    List<Integer> list=new ArrayList<Integer>();
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        inorder(root);
        for(int i=1;i<list.size();i++)
            if(list.get(i)<=list.get(i-1)) return false;

        return true;
    }
    public void inorder(TreeNode root){
        if(root==null)return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);

    }
}

//第二次  中序遍历

public class Solution {
    TreeNode pre = null;

    public boolean isValidBST(TreeNode root) {
        // Traverse the tree in inorder.
        if (root != null) {
            // Inorder traversal: left first.
            if (!isValidBST(root.left)) return false;   //先看左节点是否有效  先深入到最左侧的节点

            // Compare it with the previous value in inorder traversal.
            if (pre != null && root.val <= pre.val) return false;

            // Update the previous value.
            pre = root;                                //root的变化是左中右的顺序

            // Inorder traversal: right last.
            return isValidBST(root.right);
        }
        return true;
    }

}
//
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}