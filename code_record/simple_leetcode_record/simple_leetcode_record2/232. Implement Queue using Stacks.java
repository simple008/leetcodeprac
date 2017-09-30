/*Created by ${USER} on ${DATE}.
 *题意：用栈 实现队列
 *注意：
 *思路：两个栈 循环搞
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
class MyQueue {
    Stack<Integer> sa=new Stack<Integer>();
    Stack<Integer> sb=new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        if(sa.isEmpty())
            while(!sb.isEmpty())
                sa.push(sb.pop());
        sa.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(sb.isEmpty())
            while(!sa.isEmpty())
                sb.push(sa.pop());
        sb.pop();
    }

    // Get the front element.
    public int peek() {
        if(sb.isEmpty())
            while(!sa.isEmpty())
                sb.push(sa.pop());
        return sb.peek();
    }

    // Return whether the queue is Empty.
    public boolean empty() {
        return sa.isEmpty()&&sb.isEmpty();
    }
}
