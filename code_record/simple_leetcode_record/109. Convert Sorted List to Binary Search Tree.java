/*Created by ${USER} on ${DATE}.
 *题意：把链表转成平衡二叉树
 *注意：
 *思路：遍历链表放到list里 然后遍历list 二分取 跟108一样
 *一刷：
 *二刷：跟 转化数组一样的思路 先遍历一遍 把节点都存到列表里 然后二分取值
 *复杂度分析：
 *反思：
 */

//第一次

//第二次
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list=new ArrayList<Integer>();
        if(head==null) return null;
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        int start=0;
        int end=list.size()-1;
        return getTree(list,0,end);
    }
    public TreeNode getTree(List<Integer> list,int start,int end){
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(list.get(mid));
        root.left=getTree(list,start,mid-1);
        root.right=getTree(list,mid+1,end);
        return root;

    }
}