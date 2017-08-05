package leetcoe_test;

/**
 * Created by lpeiz on 2017/5/21.
 */
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
