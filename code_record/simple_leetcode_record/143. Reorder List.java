/*Created by ${USER} on ${DATE}.
 *���⣺��������˳��123456--162534
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��merge��ʱ����ʱ����node1 ��node1��dummy����һ��ģ������»������
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return ;
        ListNode dummy=head;
        ListNode slow=findmid(head);
        ListNode newhead=reverse(slow.next);
        slow.next=null;
        merge(dummy,newhead);

    }
    public ListNode findmid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode newhead=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }
    public void merge(ListNode head1,ListNode head2){
        int index=0;
        ListNode dummy=new ListNode(0);
        while(head1!=null&&head2!=null){
            if(index%2==0){
                dummy.next=head1;
                head1=head1.next;
            }
            else{
                dummy.next=head2;
                head2=head2.next;
            }
            dummy=dummy.next;
            index++;
        }
        if(head1!=null)
            dummy.next=head1;
        else dummy.next=head2;
    }
}
//�ڶ���
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return ;
        ListNode dummy = head;
        ListNode mid = findMid(head);
        mid = reverse(mid);
        merge(dummy,mid);
    }
    public void merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        while(node1 != null && node2 != null){
            dummy.next = node1;
            dummy = dummy.next;
            node1 = node1.next;
            dummy.next = node2;
            dummy = dummy.next;
            node2 = node2.next;
        }
        if(node1 != null)
            dummy.next = node1;
    }
    public ListNode findMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast=fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }
    public ListNode reverse(ListNode head){

        ListNode newhead = null;
        ListNode temp = null;
        while(head != null ){
            temp = head.next;
            head.next = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;
    }
}