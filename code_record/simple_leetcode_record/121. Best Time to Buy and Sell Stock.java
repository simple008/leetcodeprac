/*Created by ${USER} on ${DATE}.
 *题意：买卖股票的最佳时间，只有一次交易买卖机会
 *注意：
 *思路：记录一个最小值，比较当前值跟最小值得 差
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution{
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int max=0;
        int min=prices[0];
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min) min=prices[i];
            max=Math.max(max,prices[i]-min);
        }
        return max;
    }
}
//第二次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int min = prices[0];
        int max = 0;
        for(int i = 1; i < len; i++){
            max = Math.max(max,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}