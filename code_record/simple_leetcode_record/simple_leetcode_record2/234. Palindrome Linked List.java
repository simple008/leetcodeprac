/*Created by ${USER} on ${DATE}.
 *题意：判断回文链表
 *注意：
 *思路：找到一半的位置 reverse 比较
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null) slow=slow.next;
        slow=reverse(slow);
        while(slow!=null&&slow.val==head.val){
            slow=slow.next;
            head=head.next;
        }
        return slow==null;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}