/*Created by ${USER} on ${DATE}.
 *���⣺�������� �ڵ��ǰ�����һ�����ֵķ��� ����(2 -> 4 -> 3) ��342 ��������������ĺͣ��ͻ����÷������ʽ����ʾ
 * (2 -> 4 -> 3) + (5 -> 6 -> 4)====7 -> 0 -> 8
 *˼·����ͷ��ʼ���������־λ�Ƿ��н�λ��1.ע�������ڵ㲻ͬʱ�����������ע�������ڵ��н���ʱ�н�λ�����
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼���������ļ����Խ�� ����Ҫ��ͷ�巨 ֱ�Ӽ��Ƿ��λ���ɣ���λҲֻ���һλ
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        head.next=l1;
        int sum=0;int dig=0;int next=0;
        if(l1==null&&l2==null)return null;
        else if(l1==null) return l2;
        else if(l2==null) return l1;
        while((l1!=null)&&(l2!=null)){
            sum=l1.val+l2.val+next;
            dig=sum%10;
            l1.val=dig;
            next=sum/10;
            // if(l1.val==10){
            //     l1.val=0;
            //     next++;
            // }
            if(l1.next==null||l2.next==null)
                break;
            l1=l1.next;
            l2=l2.next;
        }
        if(l2.next!=null){
            l1.next=l2.next;

        }
        while(l1.next!=null){
            l1=l1.next;
            sum=l1.val+next;
            l1.val=sum%10;
            next=sum/10;
        }
        // while(l2.next!=null){
        //     l1.next=l2.next;
        //     sum=l1.val+next;
        //     l1.val=sum%10;
        //     next=sum/10;
        // }
        if(next!=0) {
            ListNode last=new ListNode(next);
            l1.next=last;
        }
        return head.next;
    }
}

/*
��������ޱ�  �泤�ޱ�
������һ�¿����õ�һ�εĴ���  �����½����� ��λ������Ҫ��if���ж�ֱ����ȡ��ȡ��ͺ��ˣ����Թ�һ������
�ٶ��Ե�һ������Ϊ��׼�������һ�������ȱ����ô��1����2  ���2�ȿ����������1
����ж�һ���Ƿ��н�λ������
����ĸ��������ÿһ����������ظ����жϹ��� ���߳�
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        dummy.next=head;
        boolean flag=false;
        // reverse(l1);
        // reverse(l2);
        int value=0,sum=0;
        while(l1!=null&&l2!=null){
            sum=l1.val+l2.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            sum=l1.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            sum=l2.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l2=l2.next;
        }
        if(flag){
            ListNode now=new ListNode(1);
            head.next=now;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode newhead=null;
        ListNode temp=null;
        while(head!=null){
            temp=head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }
}