/*Created by ${USER} on ${DATE}.
 *题意：1-26 a-z 编码  给一个数字字符串 计算有多少种解码可能
 *注意：
 *思路：动态规划，如果n n-1 构成10-26 的数字，那么当n n-1 作为一个数字解码时 dp[n]=dp[n-2]
 *      如果 n-1 作为一个数字解码那么dp[n]=dp[n-1]  但是这种情况有限制，就是n不能是0 如果是0 只能是跟n-1结合
 *      同时注意几种corner ：
 *          1.当前是0 前以为只能是1 或2
 *          2. 开头第一位不能是0
 *          3. 从索引1开始遍历 要注意索引1的情况 如果是1 n-2越界
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int numDecodings(String s) {
        int n=s.length();
        if(n==0|| s=="") return 0;

        int []num =new int [n+1];
        num[n]=1;
        num[n-1]=s.charAt(n-1)!='0'?1:0;

        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='0') continue;
            else num[i]=(Integer.parseInt(s.substring(i,i+2))<=26)?num[i+1]+num[i+2]:num[i+1];

        }
        return num[0];

    }
}

//第二次
public class Solution {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        if(s.charAt(0)=='0') return 0;
        int dp[]=new int[s.length()];
        dp[0]=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='0'&&(s.charAt(i-1)!='1'&&s.charAt(i-1)!='2')) return 0;
            if((s.charAt(i-1)=='1'&&(s.charAt(i)-'0'<10))||(s.charAt(i-1)=='2'&&s.charAt(i)-'0'<7)){
                if(i==1) dp[1]=1;
                else dp[i]=dp[i-2];
                if(s.charAt(i)!='0') dp[i]+=dp[i-1];

            }
            else dp[i]=dp[i-1];
        }
        return dp[s.length()-1];
    }
}