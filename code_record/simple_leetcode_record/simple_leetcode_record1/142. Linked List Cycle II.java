/*Created by ${USER} on ${DATE}.
 *题意：链表是否有环，找出环的地址
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=new ListNode(0);
        ListNode slow=new ListNode(0);
        fast=head;
        slow=head;
        // ListNode fast=head;
        // ListNode slow=head;
        Solution solu=new Solution();
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                //     while(head!=fast){
                //     head=head.next;
                //     fast=fast.next;
                // }
                // return head;
                while(head!=fast){
                    solu.search(head,fast);
                }

            }
        }
        return null;
    }
    public ListNode search(ListNode head,ListNode meet){
        while(head!=meet){
            head=head.next;
            meet=meet.next;
        }
        return meet;
    }
}


//第二次    用dummy 开始和head作为快慢指针的开始都可以 但是 在判断已经有环需要重新开始跑时需要保持一致，如果从head开始就用head，如果是dummy就用dummy

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        fast = head;
        ListNode slow = fast;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while (slow != head){
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;

    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = new ListNode(0);
        fast.next = head;
        ListNode slow = fast;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = new ListNode(0);
                slow.next = head;
                while (slow != fast){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;

    }
}