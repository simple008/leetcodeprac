/*Created by ${USER} on ${DATE}.
 *题意：给定一个字符串  计算有多少种计算可能  = - ×Input: "2-1-1".
((2-1)-1) = 0
(2-(1-1)) = 2
 *注意：
 *思路：不断递归，遍历字符串遇到符号 就分为两部分  两部分分别递归 计算一个结果  重复的结果也算不去重  a+b+c
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */


Given a string of numbers and operators,
        return all possible results from computing all the different possible
        ways to group numbers and operators. The valid operators are +, - and *.
//第一次
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<input.length();i++){
            char a=input.charAt(i);
            if(a=='+'||a=='-'||a=='*'){
                String s1=input.substring(0,i);
                String s2=input.substring(i+1);
                List<Integer> a1=diffWaysToCompute(s1);
                List<Integer> a2=diffWaysToCompute(s2);
                for(int m:a1){
                    for(int n:a2){
                        if(a=='+')
                            list.add(m+n);
                        else if(a=='-')
                            list.add(m-n);
                        else if(a=='*')
                            list.add(m*n);
                    }
                }
            }
        }
        if(list.size()==0) list.add(Integer.valueOf(input));
        return list;
    }
}
