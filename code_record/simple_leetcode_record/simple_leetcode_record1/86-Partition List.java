/*Created by ${USER} on ${DATE}.
 *题意：一个乱序链表 ，把小于x的值放到前面其余放到后面 并不改变相对顺序
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第二次   另开两个链表
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null) return head;
        ListNode a=new ListNode(0);
        ListNode aa=a;
        ListNode b=new ListNode(0);
        ListNode bb=b;
        while(head!=null){
            if(head.val<x){
                a.next=head;
                head=head.next;
                a=a.next;
                a.next=null;
            }else{
                b.next=head;
                head=head.next;
                b=b.next;
                b.next=null;
            }
        }
        a.next=bb.next;
        return aa.next;
    }
}