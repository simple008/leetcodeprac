/*Created by ${USER} on ${DATE}.
 *题意：一棵二叉树从右侧看 看到的所有节点
 *注意：
 *思路：
 *一刷：递归 记录list的大小和层深，层深和大小相同时加进去说明是第一次本层的点
 *二刷：层次遍历 最后一个节点
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    List<Integer> list=new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root!=null) right(root,0);
        return list;
    }
    public void right(TreeNode root,int level){
        if(root==null) return ;
        if(level==list.size()) list.add(root.val);
        right(root.right,level+1);
        right(root.left,level+1);

    }
}
//第二次
public class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return list;
        right(root,0);
        return list;
    }
    public void right(TreeNode root,int level){
        if(root == null) return ;
        if(level == list.size()) list.add(root.val);
        right(root.right,level+1);
        right(root.left,level+1);
    }
}

//第三次
class Solution {
    List<Integer> list = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return list;
        order(root,0);
        return list;
    }
    public void order(TreeNode root, int level){
        if(root == null) return;
        if(level == list.size()) list.add(root.val);
        order(root.right,level+1);
        order(root.left, level+1);
    }
}