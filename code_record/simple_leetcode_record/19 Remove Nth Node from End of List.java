/*Created by ${USER} on ${DATE}.
 *题意：返回删除了倒数第n个节点后的链表
 *注意：注意直接删除了head节点的情况
 *思路：单独关注删除第一个节点的情况
 *一刷：辅助节点等于head
 *二刷：辅助节点next=head
 *复杂度分析：
 *反思： 需要操作头结点时尽量使用next辅助
 *
 *
 */
//
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode low=head;

        for (int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        if (fast==null)
            return head.next;
        while(fast.next!=null)
        {
            fast=fast.next;
            low=low.next;
        }
        low.next=low.next.next;
        return head;

    }
}


//for循环过n次再用快慢指针找倒数第n个节点并删除
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast=head;
        ListNode low=head;

        for (int i=0;i<n;i++)
        {
            fast=fast.next;
        }
        if (fast==null)
            return head.next;
        while(fast.next!=null)
        {
            fast=fast.next;
            low=low.next;
        }
        low.next=low.next.next;
        return head;

    }
}