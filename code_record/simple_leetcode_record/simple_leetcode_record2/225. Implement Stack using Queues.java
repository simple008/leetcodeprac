/*Created by ${USER} on ${DATE}.
 *题意：用队列实现栈  push pop empty top
 *注意：
 *思路：两个队列 实现， 或者 是用一个队列  在每次push的时候把所有的值都从头取出来放到尾部
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
class MyStack {
    // Push element x onto stack.
    Queue<Integer> queue;

    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}