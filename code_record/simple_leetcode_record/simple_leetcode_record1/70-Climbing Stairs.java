/*Created by ${USER} on ${DATE}.
 *题意：爬楼梯问题，一次可以爬两阶或者一阶 求n的方案数
 *注意：
 *思路：dp[n]=dp[n-1]+dp[n-2]  初始化0 1 2 位置 注意越界问题
 *一刷：初始化了 0 1
 *二刷：没有问题 初始化0 1 2  感觉更好理解一些
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int climbStairs(int n) {
        int []arr=new int[n+1];
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<n+1;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
}
//第二次
public class Solution {
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}