/*Created by ${USER} on ${DATE}.
 *题意：(){}[]判断是否是有效的括号组合
 *注意：
 *思路：用栈结构 更快  replace 方法反而时间更长
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack =new Stack<Character>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(s.charAt(i)==')'&&!stack.empty()&&stack.peek()=='(')
                stack.pop();
            else if(s.charAt(i)==']'&&!stack.empty()&&stack.peek()=='[')
                stack.pop();
            else if(s.charAt(i)=='}'&&!stack.empty()&&stack.peek()=='{')
                stack.pop();
            else return false;
        }
        return stack.empty();
    }
}

public class Solution {
    public boolean isValid(String s) {
        int length;

        do {
            length = s.length();
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        } while(length != s.length());

        return s.length() == 0;
    }
}

//第二次
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'&&!stack.isEmpty()&&stack.peek()=='('){
                stack.pop();
            }
            else if(s.charAt(i)==']'&&!stack.isEmpty()&&stack.peek()=='['){
                stack.pop();
            }else if(s.charAt(i)=='}'&&!stack.isEmpty()&&stack.peek()=='{'){
                stack.pop();
            }else if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else
                return false;
        }
        return stack.isEmpty();
    }
}