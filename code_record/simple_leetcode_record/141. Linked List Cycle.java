/*Created by ${USER} on ${DATE}.
 *题意：判断链表是否有环
 *注意：快慢指针
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode head1;
        head1=head;
        ListNode head2=head1;
        while(head1!=null&&head2!=null&&head2.next!=null){
            head1=head1.next;
            head2=head2.next.next;
            if(head1==head2)
                return true;
        }
        return false;

    }
}
//第二次
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        ListNode slow = new ListNode(0);
        fast = head;
        slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
}
