/*Created by ${USER} on ${DATE}.
 *���⣺�ж������Ƿ��л�
 *ע�⣺����ָ��
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode head1;
        head1=head;
        ListNode head2=head1;
        while(head1!=null&&head2!=null&&head2.next!=null){
            head1=head1.next;
            head2=head2.next.next;
            if(head1==head2)
                return true;
        }
        return false;

    }
}
//�ڶ���
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast = head;
        slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
