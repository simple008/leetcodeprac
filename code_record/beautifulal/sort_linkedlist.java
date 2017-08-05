package listnode;
/**
 * @author Gavenyeah
 * @date Start_Time��2016��4��1�� ����14:07:04
 * @date End_Time��2016��4��1�� ����14:55:04
 */
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