/*Created by ${USER} on ${DATE}.
 *���⣺���������nextָ���⻹����һ�����ָ��ָ��һ������Ľڵ� ����һ����ͬ�Ľڵ�
 *ע�⣺
 *˼·���ȸ���һ�����нڵ㣬ÿ���½ڵ���ԭ���ڵ����һλ����������ڵ�ָ�룻�ٰ�����ż��λ�ֿ� ������ĸ���
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��bugû������GG ���Ǹ��ƵĴ���  ˼·һ��
 */

//��һ�� public class Solution {

public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
        return null;
        }

        copyNode(head);
        linkRandomPointer(head);

        return splitList(head);
        }

/**
 * ���ƽ�㣬���ƵĽ����ڴ����ƵĽ�����Ȼ���һ��������
 *
 * @param head ����ͷ
 */
public void copyNode(RandomListNode head) {
        // ��¼��ǰҪ�����Ƶ���
        RandomListNode node = head;
        while (node != null) {
        // ����һ���µĽ��
        RandomListNode copyNode = new RandomListNode(node.label);
        // ����㴮�ӵ������ƵĽ��󣬲�����Ȼ��ɵ�����
        copyNode.next = node.next;
        node.next = copyNode;
        node = copyNode.next;
        }
        }

/**
 * �������ָ��
 *
 * @param head ����ͷ
 */
public void linkRandomPointer(RandomListNode head) {
        // ��¼��ǰҪ�����Ƶ���
        RandomListNode node = head;
        while (node != null) {
        // ���ָ����ָ��ĳ������Ľ��
        if (node.random != null) {
        // ����node�����ƽ������ָ��
        node.next.random = node.random.next;
        }

        // ָ����һ�������ƵĽ��
        node = node.next.next;
        }
        }

/**
 * �������֣���ԭԭ��������������װ����������
 *
 * @param head ����ͷ
 * @return ������������ͷ
 */
public RandomListNode splitList(RandomListNode head) {
        // ������ͷ
        RandomListNode copyHead = head.next;
        // ��ǰ����ı����ƵĽ��
        RandomListNode node = head;
        // ��ǰ���ƵĽ��
        RandomListNode copy;

        while (node != null){
        // ָ���ƽ��
        copy = node.next;

        // node.nextָ����һ�������ƵĽ��
        node.next = copy.next;

        // ��һ�������ƵĽ�㲻Ϊnull
        if (node.next != null) {
        // copy.nextָ����һ�����ƵĽ��
        copy.next = node.next.next;
        }

        // nodeָ����һ��Ҫ������ı����ƽ��
        node = node.next;
        }
        return copyHead;
        }
        }