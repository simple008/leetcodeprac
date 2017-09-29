/*Created by ${USER} on ${DATE}.
 *题意：可以进行多次买卖，但是同一天只能进行一次操作，在买之前必须已经卖出了所有股票
 *注意：
 *思路：如果当前值比前一个大就把这个差值加进来
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int maxProfit(int[] prices) {
        int maxfit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1])
                maxfit+=prices[i]-prices[i-1];
        }
        return maxfit;

    }
}
//第二次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        int sum = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > prices[i-1])
                sum += prices [i] - prices[i-1];
        }
        return sum;
    }
}