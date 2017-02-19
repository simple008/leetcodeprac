/*Created by ${USER} on ${DATE}.
 *题意：旋转列表
 *注意：是把后半段放到前面，没有翻转 简单很多 需要注意给定的k超过链表长度 所以需要取模
 *思路：因为给定的k可能超过链表的长度所以需要先遍历一遍记录链表的长度，再下一步操作。在使用时尽量使用dummy指针
 *
 *一刷：
 *二刷：让slow=head 结果最后把slow.next给了dummy返回  如果链表只有一个节点那么它会返回空链表
 *复杂度分析：
 *反思：
 *
 *
 */

//第一次


//第二次

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return head;
        ListNode fast=head;

        int len=1;
        while(fast.next!=null){
            fast=fast.next;
            len++;
        }
        fast.next=head;
        for(int i=0;i<len-k%len;i++){
            fast=fast.next;
        }

        head=fast.next;
        fast.next=null;


        // ListNode temp=new ListNode(0);

        return head;
    }
}


//AC

public class Solution {

    public ListNode rotateRight(ListNode head, int n) {
        if (head==null||head.next==null) return head;

        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;
        int i=0;
        while(fast!=null&&fast.next!=null){
            fast=fast.next;
            i++;
        }

        for(int j=0;j<i-n%i;j++){
            slow=slow.next;
        }
        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

        return dummy.next;

    }
}
// wrong

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return head;
        ListNode fast=head;
        ListNode slow=fast;

        int len=1;
        while(fast.next!=null){
            fast=fast.next;
            len++;
        }

        for(int i=0;i<len-k%len;i++){
            slow=slow.next;
        }
        fast.next=head;

        ListNode dummy=slow.next;        //slow 指针可能是空  这么赋值会可能会返回空链表 所以少用head而是用dummy指针
        slow.next=null;


        // ListNode temp=new ListNode(0);

        return dummy;
    }
}
//上面修改后
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0) return head;
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;

        int len=0;
        while(fast.next!=null){
            fast=fast.next;
            len++;
        }

        for(int i=0;i<len-k%len;i++){
            slow=slow.next;
        }
        fast.next=head;

        dummy=slow.next;
        slow.next=null;


        // ListNode temp=new ListNode(0);

        return dummy;
    }
}


