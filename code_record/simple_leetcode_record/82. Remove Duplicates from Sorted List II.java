/*Created by ${USER} on ${DATE}.
 *���⣺��������ɾ���ظ��ڵ㣬��ֵ�ظ��Ľڵ�ֵ��ɾ��һ����ʣ
 *˼·��������������һ��newhead��һ��pre����whileѭ���ڻ�Ҫ��һ��whileѭ����
 * �ظ��Ľڵ㶼����ȥ��ͬʱ��pre.next==head���ж��Ƿ��������ڵ�����������
 * ע�⣺��Ҫ����headÿ�ζ�Ҫ�ƶ� ��pre����Ҫpre���ƶ������жϹ����н��е�
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
/*
һˢ
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode newhead=new ListNode(0);
        ListNode pre=newhead;
        pre.next=head;
        // newhead.next=head;
        // ListNode cur=newhead;

        while(head!=null){
            while(head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            if(pre.next==head)
                pre=pre.next;
            else {
                pre.next=head.next;
            }
            head=head.next;
        }
        return newhead.next;

    }
}

/*
����û������ Ӧ��ÿ�ζ�����ͼ��ϸ������д��  head=head.next
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode pre=newhead;
        while(head!=null){
            while(head!=null&&head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            if(pre.next!=head){
                pre.next=head.next;   //ע�����ﲻ���ƶ�preֻ�ǰ�nextָ��ָ��ȥ��
                                      // ��Ϊ����pre.nextָ���λ�ò�һ�������ظ���
            }
            else{
                pre=head;
            }
            head=head.next;
        }
        return newhead.next;
    }
}