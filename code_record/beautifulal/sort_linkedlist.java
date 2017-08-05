package listnode;
/**
 * @author Gavenyeah
 * @date Start_Time：2016年4月1日 下午14:07:04
 * @date End_Time：2016年4月1日 下午14:55:04
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
            Node cur=head;  //比较节点，每次都是从头节点开始
            Node q=p.next;
            if(p.data<head.data){ //由于是单链表，每次只能从头节点开始比较
                pre.next=q;
                p.next=head;
                head=p;
            }else
                while(cur.next!=p){
                    if(p.data<cur.next.data){//将P与cur.next进行比较，方便单链表插入
                        pre.next=q;
                        p.next=cur.next;
                        cur.next=p;
                        p=pre;  //保证pre每次指向的都是p前面的一个节点
                    }else
                        cur=cur.next;
                }
            pre=p;
            p=q;
        }
        return head;
    }
}