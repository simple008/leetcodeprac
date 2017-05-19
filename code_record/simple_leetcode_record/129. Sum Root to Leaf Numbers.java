/*Created by ${USER} on ${DATE}.
 *���⣺
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int sumNumbers(TreeNode root) {
        return preorder(root,0);
    }
    public int preorder(TreeNode root,int s){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return s*10+root.val;
        return preorder(root.left,s*10+root.val)+preorder(root.right,s*10+root.val);
    }
}

//�ڶ���
public class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sumR(root,0);
        return sum;
    }
    public void sumR(TreeNode root, int cnt){
        if(root == null ) return ;
        if(root.left == null && root.right == null){
            sum += cnt*10 + root.val;
            return ;
        }
        sumR(root.left, cnt*10 + root.val);
        sumR(root.right, cnt*10 + root.val);
    }
}