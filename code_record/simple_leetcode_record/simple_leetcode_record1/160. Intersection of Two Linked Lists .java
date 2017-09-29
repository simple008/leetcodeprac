/*Created by ${USER} on ${DATE}.
 *题意：求两个Y型链表的交点。 如果没有交点 返回null
 *注意：
 *思路：先计算两个链表的长度然后同时开始走 走到最后相等 返回这个节点。即使没有交点，这样最后相等的时候会是null
 *  同样返回就行了
 *      之前的想法是A走完了连到B的头，B走完了连到A的头这样的问题是如果没有交点会死循环。。
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        if(insect(headA,headB)){
            int a=lenof(headA)-lenof(headB);
            if(a>=0){
                while(a-->0){
                    headA=headA.next;
                }
                while(headA!=null&&headA.val!=headB.val)
                {
                    headA=headA.next;
                    headB=headB.next;
                }
                return headA;
            }
            else{
                int b=-a;
                while(b-->0){
                    headB=headB.next;
                }
                while(headA!=null&&headA.val!=headB.val)
                {
                    headA=headA.next;
                    headB=headB.next;
                }
                return headA;
            }

        }
        return null;
    }

    public boolean insect(ListNode head1,ListNode head2){
        int val1=0,val2=0;
        while(head1!=null){

            val1=head1.val;
            head1=head1.next;
        }
        while(head2!=null){

            val2=head2.val;
            head2=head2.next;
        }
        return val1==val2;
    }
    public int lenof(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

}
//第二次
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int lenA=lenof(headA);
        int lenB=lenof(headB);
        while(lenA>lenB){
            headA=headA.next;
            lenA--;
        }while(lenA<lenB){
            headB=headB.next;
            lenB--;
        }

        while(headA!=headB)
        {
            headA=headA.next;
            headB=headB.next;
        }
        return headA;

    }

    public int lenof(ListNode head){
        int len=0;
        while(head!=null){
            head=head.next;
            len++;
        }
        return len;
    }

}