/*Created by ${USER} on ${DATE}.
 *题意：两个已经排序的链表合并成一个
 *注意：
 *思路：
 *一刷：使用了两个辅助节点，不断向前推进
 *二刷：在原链表上进行操作 先找出来较小的链表做为基准进行操作，  法一似乎更好一些 快很多，省劲
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次   70%
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null||l2==null)
            return l1==null?l2:l1;
        ListNode fin=new ListNode(0);
        ListNode newhead=fin;
        // ListNode newhead =null;
        // ListNode next=newhead;
        while(l1!=null||l2!=null){
            if(l2==null||(l1!=null && l1.val<l2.val) )
            {
                newhead.next=l1;
                l1=l1.next;
                newhead=newhead.next;
            }
            else {
                newhead.next = l2;
                l2 = l2.next;
                newhead = newhead.next;
            }
        }
        return fin.next;
    }
}
//第二次  2%
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode dummy=new ListNode(0);
        ListNode privot=new ListNode(0);
        if(l1.val<l2.val){
            dummy.next=l1;
            privot.next=l2;
        }else{
            dummy.next=l2;
            privot.next=l1;
        }
        ListNode head=dummy;
        while(head.next!=null&&privot.next!=null){
            if(head.next.val<privot.next.val){
                head=head.next;
            }else{
                ListNode temp=privot.next;
                privot.next=privot.next.next;
                temp.next=head.next;
                head.next=temp;
            }
        }
        if(head.next==null&&privot.next!=null){
            head.next=privot.next;
        }
        return dummy.next;
    }
}