/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

//第一次

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre=new ListNode(0);
        pre.next=head;
        ListNode temp=new ListNode(0);

        while(head){
            for(int i=0;i<k;i++){
                if(head.next==null)
                    return
                else head=head.next;
            }
            temp=head.next;
            head.next=null;
            head=temp;
            temp=pre.next;
            pre.next=reverse(pre.next);
            temp.next=head;
            pre=temp;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode newhead=head;
        ListNode temp=new ListNode(0);
        while(head!=null&&head.next!=null){
            temp=head.next;
            head.next=temp.next;
            temp.next=newhead;
            newhead=temp;
        }
        return newhead;
    }
}

