/*Created by ${USER} on ${DATE}.
 *���⣺������
 *ע�⣺
 *˼·��ͷ�巨
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead =null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=newhead;
            newhead=head;
            head=next;
        }
        return newhead;
    }
}
//�ڶ���
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;
    }
}