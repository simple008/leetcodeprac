/*Created by ${USER} on ${DATE}.
 *题意：计算器 +-×/ 空格  五种情况实现计算器
 *注意：
 *思路：借助栈，把局部结果压栈，保存前一次的运算符，压栈之后 再更新运算符号
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
    public class Solution {
        public int calculate(String s) {
            Stack<Integer> stack=new Stack<>();
            int num=0;
            char sign='+';
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))){
                    num=num*10+s.charAt(i)-'0';
                }
                if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i==s.length()-1)
                {
                    if(sign=='+'){
                        stack.push(num);
                    }
                    if(sign=='-'){
                        stack.push(-num);
                    }
                    if(sign=='*'){
                        stack.push(stack.pop()*num);
                    }
                    if(sign=='/'){
                        stack.push(stack.pop()/num);
                    }
                    num=0;
                    sign=s.charAt(i);

                }
            }
            int res=0;
            for(int e:stack){
                res+=e;
            }
            return res;
        }
    }