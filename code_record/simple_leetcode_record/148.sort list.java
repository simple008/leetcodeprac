/*Created by ${USER} on ${DATE}.
 *题意：对链表进行排序
 *注意：
 *思路：从开始向后n*n   归并排序 nlogn 用递归，有一个函数不断地从开始和中间节点排序，merge两个有序的子数组
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
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
