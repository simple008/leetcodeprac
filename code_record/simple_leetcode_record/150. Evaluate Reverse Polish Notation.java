/*Created by ${USER} on ${DATE}.
 *题意：逆波兰表达式。
 *注意：
 *思路：用个栈辅助就行了，阿里笔试题做了，结果没过这次不做了很简单没什么意思
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
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