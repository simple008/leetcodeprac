/*Created by ${USER} on ${DATE}.
 *���⣺������Сջ ���Է�����Сֵ��ջ
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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
//�ڶ���
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

//������
class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){                   //���������<=������<   push 0 1 0  ��push�ڶ���0��ʱ��������ڴ���һ����Сֵ��
            stack.push(min);           //��ô������ʱ�����Ϊ��ǰ����Сֵ0 ���������0 ���ֵ���  �Ӷ�ʹ��ȷ����Сֵ�иı�
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