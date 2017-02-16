/*Created by ${USER} on ${DATE}.
 *题意：找出最长的有效的括号对
 *注意：
 *思路：从后往前找，dp，如果当前位置是(，搜索j=i+dp[i+1]+1位置是否是），
 * 如果是加2，在判断j+1位置是否在有效范围内（为越界）是，则+dp[j+1]
 *一刷：
 *二刷：参考答案
 *复杂度分析：
 *反思：hard题目
 *
 */
//第一次
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        int n=s.length();
        int longest=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else{
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    if(s.charAt(stack.peek())=='(')
                        stack.pop();
                    else stack.push(i);
                }
            }
        }
        if(stack.isEmpty()) longest=n;
        else{
            int a=n,b=0;
            while(!stack.isEmpty()){
                b=stack.peek();
                stack.pop();
                longest=Math.max(longest,a-b-1);
                a=b;
            }
            longest=Math.max(longest,a);
        }
        return longest;
    }
}

//第二次
public class Solution {
    public int longestValidParentheses(String s) {
        int []dp=new int[s.length()];
        int j=0;
        int max=0;
        for(int i=s.length()-2;i>=0;i--){
            if(s.charAt(i)=='('){
                j=i+dp[i+1]+1;
                if(j<s.length()&&s.charAt(j)==')'){
                    dp[i]=dp[i+1]+2;
                    if(j+1<s.length()-1)
                        dp[i]+=dp[j+1];
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}