/*Created by ${USER} on ${DATE}.
 *题意：实现数字字符串的乘法运算
 *注意：处理最后的结果中开头有零的情况
 *思路：用一个len1+len2的数组，len1 len2相乘最多会变成len1+len2的长度。从后往前计算，保留当前位的值和进位信息， 取余取模
 *一刷：
 *二刷：
 *复杂度分析：O(n)
 *反思：细节处理
 *
 *
 */

//第一次
public class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int p1;int p2;int sum;
        int [] pos=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                p1=i+j;p2=i+j+1;
                sum=mul+pos[p2];
                pos[p1]+=sum/10;
                pos[p2]=sum%10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m+n;i++){
            if(!(pos[i]==0&&sb.length()==0)) sb.append(pos[i]);
        }
        return sb.length()==0?"0":sb.toString();
    }
}

//第二次
public class Solution {
    public String multiply(String num1, String num2) {
        int p1=0;int p2=0;
        int len1=num1.length();
        int len2=num2.length();
        int []res=new int[len1+len2];
        for(int i=len1-1;i>=0;i--){
            for(int j=len2-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                mul=res[i+j+1]+mul;
                p1=mul%10;
                p2=mul/10;
                res[i+j]+=p2;
                res[i+j+1]=p1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len1+len2;i++){
            // sb.append(res[i]);
            if(!(res[i]==0&&sb.length()==0)) sb.append(res[i]);
        }
        return sb.length()==0?"0":sb.toString();
        // if(sb.length()==0||sb.charAt(0)=='0') return "0";
        // else return sb.toString();
    }
}