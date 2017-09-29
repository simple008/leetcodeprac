/*Created by ${USER} on ${DATE}.
 *题意：两个链表 节点从前向后是一个数字的反序 比如(2 -> 4 -> 3) 是342 求这样两个链表的和，和还是用反序的形式来表示
 * (2 -> 4 -> 3) + (5 -> 6 -> 4)====7 -> 0 -> 8
 *思路：从头开始遍历，设标志位是否有进位。1.注意两个节点不同时结束的情况，注意两个节点有结束时有进位的情况
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：进行数的计算会越界 不虚要用头插法 直接记是否进位即可，进位也只会进一位
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        head.next=l1;
        int sum=0;int dig=0;int next=0;
        if(l1==null&&l2==null)return null;
        else if(l1==null) return l2;
        else if(l2==null) return l1;
        while((l1!=null)&&(l2!=null)){
            sum=l1.val+l2.val+next;
            dig=sum%10;
            l1.val=dig;
            next=sum/10;
            // if(l1.val==10){
            //     l1.val=0;
            //     next++;
            // }
            if(l1.next==null||l2.next==null)
                break;
            l1=l1.next;
            l2=l2.next;
        }
        if(l2.next!=null){
            l1.next=l2.next;

        }
        while(l1.next!=null){
            l1=l1.next;
            sum=l1.val+next;
            l1.val=sum%10;
            next=sum/10;
        }
        // while(l2.next!=null){
        //     l1.next=l2.next;
        //     sum=l1.val+next;
        //     l1.val=sum%10;
        //     next=sum/10;
        // }
        if(next!=0) {
            ListNode last=new ListNode(next);
            l1.next=last;
        }
        return head.next;
    }
}

/*
代码奇丑无比  奇长无比
分析了一下可以用第一次的代码  不用新建链表 进位处理不需要用if来判断直接用取整取余就好了，可以归一化处理。
假定以第一条链表为基准，如果第一条链表先变空那么把1连到2  如果2先空则继续处理1
最后判断一下是否有进位就行了
这里的复杂在最后每一种情况都有重复的判断过程 很冗长
 */

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        dummy.next=head;
        boolean flag=false;
        // reverse(l1);
        // reverse(l2);
        int value=0,sum=0;
        while(l1!=null&&l2!=null){
            sum=l1.val+l2.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            sum=l1.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l1=l1.next;
        }
        while(l2!=null){
            sum=l2.val;
            if(flag)
                sum++;
            if(sum>=10){
                value=sum-10;
                flag=true;
            }
            else{
                value=sum;
                flag=false;
            }
            ListNode now=new ListNode(value);
            head.next=now;
            head=head.next;
            l2=l2.next;
        }
        if(flag){
            ListNode now=new ListNode(1);
            head.next=now;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode head){
        ListNode newhead=null;
        ListNode temp=null;
        while(head!=null){
            temp=head.next;
            head.next=newhead;
            newhead=head;
            head=temp;
        }
        return newhead;
    }
}