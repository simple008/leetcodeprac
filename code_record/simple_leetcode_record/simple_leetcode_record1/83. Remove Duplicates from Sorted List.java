/*Created by ${USER} on ${DATE}.
 *���⣺��������ɾ���ظ��Ľڵ㣬��ͬ��ֵ�������һ��
 *˼·����һ��newheadָ����һλָ��ͷ��㣬ͷ��㿪ʼ�������ֵ��ͬ��������ͬ�����ƶ�һλ
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼����¼һ�����������  �����Ҫ����newhead.next�������ô����  ��Ҫ������
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode newnode=head;
        // if(newnode.next==null) return head;
        while((newnode!=null))
        {
            if(newnode.val==newnode.next.val)
            {
                newnode.next=newnode.next.next;
            }
            else newnode=newnode.next;
        }
        return head;
    }
}
/*
��ˢ�������� ����һ��preָ�������
���Ǵ������
 */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode pre=newhead;
        while(head!=null){
            if(pre.val!=head.val){ //�����������бȽ�����pre.val=1 ���head=1����  ��ʹ��pre��ʼ��ΪheadҲ���в����ƶ�
                pre.next=head;    //preָ��û���ƶ����´���Ӧ���pre=pre.next
            }
            head=head.next;
        }
        return newhead.next;
    }
//ֱ����һ��ָ�����ȽϾͿ����ˣ���ͬ��������ͬ���ƶ�һλ
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        while(head!=null&&head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }
            else{
                head=head.next;
            }
        }
        return newhead.next;
    }
}