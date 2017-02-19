/*Created by ${USER} on ${DATE}.
 *题意：交换链表中两两相邻的节点
 *注意：因为有两个辅助节点 a b 是循环重复使用的，需要指定为公共变量 而不是在每次循环中进行重新声明这样节省大量时间 区别在法一 和法二
 *思路：
 *一刷：
 *二刷：要对head节点进行操作，建立一个辅助节点dummy 进行操作判断下个节点和下下节点是否是空
 *复杂度分析：
 *反思：
 *
 *
 */

//第一次 90%
public class Solution {
    public ListNode swapPairs(ListNode head) {

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

//第二次  2%
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode newhead=dummy;
        while(dummy.next!=null&&dummy.next.next!=null){
            ListNode a=dummy.next;
            ListNode b=dummy.next.next;
            a.next=b.next;
            b.next=a;
            dummy.next=b;
            dummy=dummy.next.next;
        }
        return newhead.next;
    }
}