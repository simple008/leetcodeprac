/*Created by ${USER} on ${DATE}.
 *���⣺�沨�����ʽ��
 *ע�⣺
 *˼·���ø�ջ���������ˣ�������������ˣ����û����β����˺ܼ�ûʲô��˼
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int num1;int num2;
        for(int i=0;i<tokens.length;i++){
        if(!(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")))
        stack.push(Integer.parseInt(tokens[i]));
        else{
        num2=stack.pop();
        num1=stack.pop();
        if(tokens[i].equals("+")){
        stack.push(num1+num2);
        }
        if(tokens[i].equals("-")){
        stack.push(num1-num2);
        }
        if(tokens[i].equals("*")){
        stack.push(num1*num2);
        }
        if(tokens[i].equals("/")){
        stack.push(num1/num2);
        }
        }
        }
        return stack.pop();
        }