/*Created by ${USER} on ${DATE}.
 *题意：链表倒置
 *注意：
 *思路：头插法
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead =null;
        while(head!=null)
        {
            ListNode next=head.next;
            head.next=newhead;
            newhead=head;
            head=next;
        }
        return newhead;
    }
}
//第二次
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        ListNode temp = null;
        while(head != null){
            temp = head.next;
            head.next = newhead;
            newhead = head;
            head = temp;
        }
        return newhead;
    }
}