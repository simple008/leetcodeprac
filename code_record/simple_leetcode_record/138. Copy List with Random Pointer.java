/*Created by ${USER} on ${DATE}.
 *题意：链表除了有next指针外还有另一个随机指针指向一个随机的节点 复制一个相同的节点
 *注意：
 *思路：先复制一遍所有节点，每个新节点在原来节点的下一位；连接随机节点指针；再把奇数偶数位分开 完成最后的复制
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：bug没调出来GG 这是复制的代码  思路一样
 */

//第一次 public class Solution {

public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        return null;
        }

        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
        }

/**
 * 复制结点，复制的结点放在待复制的结点后，依然组成一个单链表
 *
 * @param head 链表头
 */
public void copyNode(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
        // 复制一个新的结点
        RandomListNode copyNode = new RandomListNode(node.label);
        // 将结点串接到被复制的结点后，并且依然组成单链表
        copyNode.next = node.next;
        node.next = copyNode;
        node = copyNode.next;
        }
        }

/**
 * 串接随机指针
 *
 * @param head 链表头
 */
public void linkRandomPointer(RandomListNode head) {
        // 记录当前要被复制的缜
        RandomListNode node = head;
        while (node != null) {
        // 随机指针有指向某个具体的结点
        if (node.random != null) {
        // 串接node被复制结点的随机指针
        node.next.random = node.random.next;
        }

        // 指向下一个被复制的结点
        node = node.next.next;
        }
        }

/**
 * 将链表拆分，还原原来的链表，并且组装拷贝的链表
 *
 * @param head 链表头
 * @return 拷贝的新链表头
 */
public RandomListNode splitList(RandomListNode head) {
        // 新链表头
        RandomListNode copyHead = head.next;
        // 当前处理的被复制的结点
        RandomListNode node = head;
        // 当前复制的结点
        RandomListNode copy;

        while (node != null){
        // 指向复制结点
        copy = node.next;

        // node.next指向下一个被复制的结点
        node.next = copy.next;

        // 下一个被复制的结点不为null
        if (node.next != null) {
        // copy.next指向下一个复制的结点
        copy.next = node.next.next;
        }

        // node指向下一个要被处理的被复制结点
        node = node.next;
        }
        return copyHead;
        }
        }