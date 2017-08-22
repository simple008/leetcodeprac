
package leetcoe_test;


/**
 * Created by lpeiz on 2017/5/21.
 */
public class reorderlist{
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println(swapPairs(node1));

    }
    public static ListNode swapPairs(ListNode head) {

        ListNode newHead=new ListNode(0);;
        newHead.next=head;
        ListNode  newhead=newHead;
        ListNode first;
        ListNode second;

        while(newhead.next!=null&&newhead.next.next!=null)
        {
            first=newhead.next;
            second=newhead.next.next;

            first.next=second.next;
            second.next=first;
            newhead.next=second;
            newhead=newhead.next.next;



        }
        return newHead.next;


    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


/*

public class reorderlist {
    public static void main(String[] args){

    }
    public void reorderList(ListNode head) {
        if(head == null) return ;
        ListNode dummy = head;
        ListNode mid = findMid(head);
        System.out.println(mid.val);
        mid = reverse(mid);
        System.out.println(mid.val);
        merge(dummy,mid);
    }
    public void merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        while(node1 != null && node2 != null){
            dummy.next = node1;
            dummy = dummy.next;
            dummy.next = node2;
            dummy = dummy.next;
            node1 = node1.next;
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
*/
