/*Created by ${USER} on ${DATE}.
 *���⣺һ�ö��������Ҳ࿴ ���������нڵ�
 *ע�⣺
 *˼·��
 *һˢ���ݹ� ��¼list�Ĵ�С�Ͳ������ʹ�С��ͬʱ�ӽ�ȥ˵���ǵ�һ�α���ĵ�
 *��ˢ����α��� ���һ���ڵ�
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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
//�ڶ���
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