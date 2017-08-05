/*Created by ${USER} on ${DATE}.
 *题意：调整链表顺序，123456--162534
 *注意：
 *思路：
 *一刷：
 *二刷：merge的时候随时更新node1 ，node1和dummy是在一块的，不更新会出问题
 *复杂度分析：
 *反思：
 */
//第一次
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
//第二次
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