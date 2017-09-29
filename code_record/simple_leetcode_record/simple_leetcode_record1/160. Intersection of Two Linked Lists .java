/*Created by ${USER} on ${DATE}.
 *���⣺������Y������Ľ��㡣 ���û�н��� ����null
 *ע�⣺
 *˼·���ȼ�����������ĳ���Ȼ��ͬʱ��ʼ�� �ߵ������� ��������ڵ㡣��ʹû�н��㣬���������ȵ�ʱ�����null
 *  ͬ�����ؾ�����
 *      ֮ǰ���뷨��A����������B��ͷ��B����������A��ͷ���������������û�н������ѭ������
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//��һ��
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        if(insect(headA,headB)){
            int a=lenof(headA)-lenof(headB);
            if(a>=0){
                while(a-->0){
                    headA=headA.next;
                }
                while(headA!=null&&headA.val!=headB.val)
                {
                    headA=headA.next;
                    headB=headB.next;
                }
                return headA;
            }
            else{
                int b=-a;
                while(b-->0){
                    headB=headB.next;
                }
                while(headA!=null&&headA.val!=headB.val)
                {
                    headA=headA.next;
                    headB=headB.next;
                }
                return headA;
            }

        }
        return null;
    }

    public boolean insect(ListNode head1,ListNode head2){
        int val1=0,val2=0;
        while(head1!=null){

            val1=head1.val;
            head1=head1.next;
        }
        while(head2!=null){

            val2=head2.val;
            head2=head2.next;
        }
        return val1==val2;
    }
    public int lenof(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

}
//�ڶ���
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int lenA=lenof(headA);
        int lenB=lenof(headB);
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }while(lenA<lenB){
            headB=headB.next;
            lenB--;
        }

        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }

    public int lenof(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

}