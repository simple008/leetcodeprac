/*Created by ${USER} on ${DATE}.
 *题意：将n个有序的链表合并成一个 n个链表以数组的形式给出
 *注意：比较器的实现！ offer poll方法区分
 * PriorityQueue<ListNode> list=new PriorityQueue<>(new Comparator<ListNode>()
 *  public int compare(ListNode l1,ListNode l2){
 *      return l1.val-l2.val;   //l1-l2是从小到大  l2-l1 是从大到下  默认从小到大！
 *  });
 *思路：遍历数组把非空的链表头存到 优先队列中 依次弹出
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy=new ListNode(-1);
        ListNode node=dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        for(ListNode head:lists){
            if(head!=null){
                pq.offer(head);
            }
        }
        while(pq.size()>0){
            node.next=pq.poll();
            node=node.next;
            if(node.next!=null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}


//第二次
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue=new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        });
        ListNode head=new ListNode(0);
        ListNode dummy=head;
        for(ListNode node:lists){
            if(node!=null){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            ListNode node=queue.poll();
            head.next=node;
            head=head.next;
            if(node.next!=null){
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}