/*Created by ${USER} on ${DATE}.
 *���⣺�������������
 *ע�⣺
 *˼·���ӿ�ʼ���n*n   �鲢���� nlogn �õݹ飬��һ���������ϵشӿ�ʼ���м�ڵ�����merge���������������
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

//quick sort

public class SortList {
    public static void main(String[] args) {
        Node head=ListNode.getSingleList();
        ListNode.printList(head);
        head=new SortList().insertSortList(head);
        ListNode.printList(head);
    }

    public Node insertSortList(Node head){
        Node p=head.next;
        Node pre=head;
        while(p!=null){
            Node cur=head;  //�ȽϽڵ㣬ÿ�ζ��Ǵ�ͷ�ڵ㿪ʼ
            Node q=p.next;
            if(p.data<head.data){ //�����ǵ�����ÿ��ֻ�ܴ�ͷ�ڵ㿪ʼ�Ƚ�
                pre.next=q;
                p.next=head;
                head=p;
            }else
                while(cur.next!=p){
                    if(p.data<cur.next.data){//��P��cur.next���бȽϣ����㵥�������
                        pre.next=q;
                        p.next=cur.next;
                        cur.next=p;
                        p=pre;  //��֤preÿ��ָ��Ķ���pǰ���һ���ڵ�
                    }else
                        cur=cur.next;
                }
            pre=p;
            p=q;
        }
        return head;
    }
}



//merge sort recursive
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=slow.next;
        slow.next=null;
        ListNode node1=sortList(head);
        ListNode node2=sortList(fast);
        return mergeList(node1,node2);
    }
    public ListNode mergeList(ListNode node1,ListNode node2){
        ListNode head=new ListNode(-1);
        ListNode last=head;
        while(node1!=null&node2!=null){
            if(node1.val<=node2.val){
                last.next=node1;
                node1=node1.next;
            }
            else{
                last.next=node2;
                node2=node2.next;
            }
            last=last.next;
        }
        if(node1!=null){
            last.next= node1;
        }
        if(node2!=null){
            last.next=node2;
        }
        return head.next;

    }
}
