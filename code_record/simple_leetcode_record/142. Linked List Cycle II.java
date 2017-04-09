/*Created by ${USER} on ${DATE}.
 *���⣺�����Ƿ��л����ҳ����ĵ�ַ
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

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


//�ڶ���    ��dummy ��ʼ��head��Ϊ����ָ��Ŀ�ʼ������ ���� ���ж��Ѿ��л���Ҫ���¿�ʼ��ʱ��Ҫ����һ�£������head��ʼ����head�������dummy����dummy

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