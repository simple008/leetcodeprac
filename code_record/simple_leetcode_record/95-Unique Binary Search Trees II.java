/*Created by ${USER} on ${DATE}.
 *题意：输出n个节点的二叉树的各种情况
 *注意：
 *思路：递归+ 动态规划：
 *      1.当为n时 说明树的构造范围为1-n 那它的根节点 有n中情况 1-n 均可，for循环遍历各种根节点的情况
 *      2.当 i为根节点时 则左子树范围 为1~i-1 右子树范围为i+1~n 递归函数getTree生成左右子树
 *      3.在当前的左右子树列表中（列表中每个元素都是一棵树的根节点）任意组合形成一棵以i为根节点的树
 *      4.把现在的节点加到结果集中
 *      5.判断出口 start>end 右子树start是在变大的 左子树end变小  如果start=end这时子树只有一个节点
 *一刷：
 *二刷：还是遇到了一些问题 仔细分析
 *复杂度分析：
 *反思：
 * 递归的理解注意 函数返回的是你想要的类型不用管里面的实现 只需要关注当层的逻辑处理
 */

//第一次


//第二次
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0) return new ArrayList<TreeNode>();
        return getTree(1,n);
    }
    public List<TreeNode> getTree(int start,int end){
        List<TreeNode> ans=new ArrayList<TreeNode>();
        if(start>end){
            ans.add(null);
            return ans;     //当前层   ans也是当前层的列表
        }
        for(int i=start;i<=end;i++){
            List<TreeNode> lTree = getTree(start,i-1);
            List<TreeNode> rTree = getTree(i+1,end);
            for(int j=0;j<lTree.size();j++){
                for(int k=0;k<rTree.size();k++){
                    TreeNode node=new TreeNode(i);
                    node.left=lTree.get(j);
                    node.right=rTree.get(k);
                    ans.add(node);
                }
            }
        }
        return ans;
    }
}