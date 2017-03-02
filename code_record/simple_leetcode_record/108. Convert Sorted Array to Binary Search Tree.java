/*Created by ${USER} on ${DATE}.
 *题意：把有序的数组 转成 二叉树
 *注意：
 *思路：二分取中点作为 根节点 依次划分范围 作为左右子树
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        return sort(nums,0,nums.length-1);
    }
    public TreeNode sort(int []nums,int start,int end){
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=sort(nums,start,mid-1);
        root.right=sort(nums,mid+1,end);
        return root ;
    }

}

//第二次
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums,0,nums.length-1);
    }
    public TreeNode getBST(int[]nums,int start,int end){
        if(start>end) return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=getBST(nums,start,mid-1);
        root.right=getBST(nums,mid+1,end);
        return root;
    }
}