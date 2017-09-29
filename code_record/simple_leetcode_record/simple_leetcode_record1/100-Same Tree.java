/*Created by ${USER} on ${DATE}.
 *题意：判断两棵树是不是同样的  节点值  相同
 *注意：
 *思路：判断是否同为空 是否不同时为空 值是否相同没什么意思
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val == q.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }
}

//第二次
public boolean isSameTree(TreeNode p, TreeNode q) {
    return inorder(p,q);
}
    public boolean inorder(TreeNode p,TreeNode q){
        if(q==null&&p==null) return true;
        if(q==null&&p!=null||q!=null&&p==null) return false;
        if(q.val!=p.val) return false;
        if(inorder(q.left,p.left)&&inorder(q.right,p.right)) return true;;

        return false;
    }
}