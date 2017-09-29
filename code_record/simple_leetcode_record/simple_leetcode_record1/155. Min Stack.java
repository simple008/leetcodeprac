/*Created by ${USER} on ${DATE}.
 *题意：构建最小栈 可以返回最小值的栈
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class MinStack {
    Stack<Long> stack;
    long min=Integer.MIN_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(0L);
            min=x;
        }
        else{
            stack.push(x-min);
            if(x<min)
                min=x;
        }
    }

    public void pop() {
        if(stack.isEmpty()) return;
        long pop=stack.pop();
        if(pop<0) min=min-pop;
    }

    public int top() {
        long top=stack.peek();
        if(top<0) {
            return (int)min;
            // min=min-top;
        }
        else return (int)(min+top);

    }

    public int getMin() {
        return (int)min;
    }
}
//第二次
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()){
            min = x;
            stack.push(x);
        }else{
            if(x > min){
                stack.push(x - min);
            }else{
                stack.push(x - min);
                min = x;
            }
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return ;
        }else{
            if(stack.peek() < 0){
                min = min - stack.peek();
            }
            stack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        if(stack.peek() > 0){
            return min + stack.peek();
        }else{
            int num = min;
            // min = min - stack.pop();
            return num;
        }
    }

    public int getMin() {
        return min;
    }
}

//第三章
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){                   //这里必须是<=不能是<   push 0 1 0  当push第二个0的时候如果不在处理一次最小值，
            stack.push(min);           //那么弹出的时候会认为当前的最小值0 来自于这个0 出现弹出  从而使正确的最小值有改变
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}