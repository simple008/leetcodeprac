/*Created by ${USER} on ${DATE}.
 *题意：有序链表，删除重复的节点，相同的值至多出现一次
 *思路：记一个newhead指针下一位指向头结点，头结点开始遍历如果值相同跳过，不同向下移动一位
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：记录一下链表的问题  如果需要返回newhead.next的情况怎么处理  需要记下来
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode newnode=head;
        // if(newnode.next==null) return head;
        while((newnode!=null))
        {
            if(newnode.val==newnode.next.val)
            {
                newnode.next=newnode.next.next;
            }
            else newnode=newnode.next;
        }
        return head;
    }
}
/*
二刷出现问题 用了一个pre指针来检测
这是错误代码
 */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode pre=newhead;
        while(head!=null){
            if(pre.val!=head.val){ //不能这样进行比较这样pre.val=1 如果head=1出错  即使把pre初始化为head也不行不能移动
                pre.next=head;    //pre指针没有移动导致错误，应添加pre=pre.next
            }
            head=head.next;
        }
        return newhead.next;
    }
//直接用一个指针来比较就可以了，相同就跳过不同就移动一位
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        while(head!=null&&head.next!=null){
            if(head.val==head.next.val){
                head.next=head.next.next;
            }
            else{
                head=head.next;
            }
        }
        return newhead.next;
    }
}