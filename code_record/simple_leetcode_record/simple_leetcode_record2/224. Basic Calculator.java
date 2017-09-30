/*Created by ${USER} on ${DATE}.
 *题意：计算器，左右括号（） +  -   空格   给定表达式都有效
 *注意：
 *思路：用栈存储 （）运算之前的结果 和 正负
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int calculate(String s) {
        Stack<Integer> val=new Stack<>();
        int sum=0;
        int sign=1;
        int result=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                sum=sum*10+(c-'0');
            }
            else if(c=='+'){
                result+=sign*sum;
                sign=1;
                sum=0;
            }
            else if(c=='-'){
                result+=sign*sum;
                sign=-1;
                sum=0;
            }
            else if(c=='('){
                val.push(result);
                val.push(sign);
                result=0;
                sign=1;
            }
            else if(c==')'){
                result+=sign*sum;
                result*=val.pop();  //正负
                result+=val.pop();  //之前的结果
                sum=0;
            }
        }
        if(sum==0) return result;
        else return result+sign*sum;

    }
}