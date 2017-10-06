/*Created by ${USER} on ${DATE}.
 *题意： 买卖股票需要冷冻一天
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int buy=-prices[0],sell=0,rest=0;
        for(int i=0;i<prices.length;i++){
            int new_buy = Math.max(rest-prices[i],buy);// 今天买 前一天休息今天买 或者是昨天买
            int new_sell = Math.max(sell,buy+prices[i]);// 今天卖 昨天卖 或者昨天买加今天的价格
            int new_rest = Math.max(rest,sell);//休息  昨天休息 和今天卖
            buy=new_buy;
            sell=new_sell;
            rest=new_rest;
        }
        return Math.max(sell,rest);
    }
}


思路：主要本题是有冰冻期的，是一个dp的题，设置两个数组buy[i]表示在第i天买了，sell[i]表示在第i天卖了之后的最大利润。

        dp[i]=max(dp[i-1],sell[i-2]-prices[i])
        sell[i]=max(sell[i-1],buy[i-1]+prices[i]);


public class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0) return 0;
        int[] sell = new int[n];
        int[] buy = new int[n];
        sell[0] = 0;
        buy[0] = -prices[0];

        for(int i=1;i<n;i++) {
            sell[i]=Math.max(sell[i-1], buy[i-1]+prices[i]);

            if(i>=2) buy[i]=Math.max(buy[i-1], sell[i-2]-prices[i]);
            else buy[i]=Math.max(buy[i-1], -prices[i]);
        }

        return sell[n-1];
    }
}