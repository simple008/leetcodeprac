/*Created by ${USER} on ${DATE}.
 *���⣺�ò�������������������
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode newhead1=new ListNode(0);
        newhead1.next=head;
        ListNode point=head;
        ListNode curn=new ListNode(0);
        ListNode cur=new ListNode(0);

        while(point.next!=null){

            if(point.val>point.next.val){
                cur=newhead1;
                while(cur.next.val<point.next.val)
                    cur=cur.next;
                curn=point.next;
                point.next=point.next.next;
                curn.next=cur.next;
                cur.next=curn;
            }
            else point=point.next;

        }
        return newhead1.next;
    }
}
//�ڶ���