/*Created by ${USER} on ${DATE}.
 *题意：有序链表删除重复节点，把值重复的节点值都删掉一个不剩
 *思路：两个辅助链表，一个newhead，一个pre，在while循环内还要有一个while循环把
 * 重复的节点都跳过去，同时用pre.next==head来判断是否有跳过节点的情况发生。
 * 注意：不要忘记head每次都要移动 而pre不需要pre的移动是在判断过程中进行的
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
/*
一刷
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode newhead=new ListNode(0);
        ListNode pre=newhead;
        pre.next=head;
        // newhead.next=head;
        // ListNode cur=newhead;

        while(head!=null){
            while(head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            if(pre.next==head)
                pre=pre.next;
            else {
                pre.next=head.next;
            }
            head=head.next;
        }
        return newhead.next;

    }
}

/*
还是没调出来 应该每次都画个图仔细分析再写。  head=head.next
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead=new ListNode(0);
        newhead.next=head;
        ListNode pre=newhead;
        while(head!=null){
            while(head!=null&&head.next!=null&&head.val==head.next.val){
                head=head.next;
            }
            if(pre.next!=head){
                pre.next=head.next;   //注意这里不能移动pre只是把next指针指过去，
                                      // 因为现在pre.next指向的位置不一定不是重复的
            }
            else{
                pre=head;
            }
            head=head.next;
        }
        return newhead.next;
    }
}