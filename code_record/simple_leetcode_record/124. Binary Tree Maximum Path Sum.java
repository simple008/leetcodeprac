/*Created by ${USER} on ${DATE}.
 *���⣺�Ӷ�����������ڵ㿪ʼ������ڵ������·�������Ƕ���
 *ע�⣺
 *˼·��������������������������ͣ��������������ͣ����������������Ӹ��ڵ�������
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//first time
public class Solution {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // if(root==null) return 0;
        int t=maxSum(root);
        return max;
    }
    public int maxSum(TreeNode root){
        if(root==null) return 0;
        int temp=root.val;

        int left=maxSum(root.left);
        int right=maxSum(root.right);

        if(left>0) temp+=left;
        if(right>0) temp+=right;

        max=Math.max(temp,max);   //�Ƚ�ȫ�����ֵ

        return Math.max(0,Math.max(left,right))+root.val;   //��ǰ��֧�����ֵ����߻����ұ�ֻ��ȡһ��������һ��
    }
}

//�ڶ���

public class Solution {
    int max = Integer.MIN_VALUE;    //���ֵ��Ϊ-max   ��������Ϊ���������
    public int maxPathSum(TreeNode root) {
        int a = sum(root);
        return max;
    }
    public int sum(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(sum(root.left),0);   //���Դ������ҷ�֮С��0�������ȥ
        int right = Math.max(sum(root.right),0);

        max = Math.max(max,left+right+root.val);
        return root.val + Math.max(left,right);   //�������շ��� rootҪ���ǵ�һ�ξ��Ǹ���������ȥ�����
    }
}