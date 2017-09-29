/*Created by ${USER} on ${DATE}.
 *题意：删除链表中所有节点等于给定值的节点
 *注意：
 *思路：简单吧
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newnode=new ListNode(0);
        ListNode newnode1=new ListNode(0);
        newnode.next=head;
        newnode1=newnode;
        //  newnode1.next=head;
        while(newnode.next!=null)
        {
            if(newnode.next.val==val)
            {
                newnode.next=newnode.next.next;
            }
            else newnode=newnode.next;
        }
        // return head.next;
        return newnode1.next;
    }
}