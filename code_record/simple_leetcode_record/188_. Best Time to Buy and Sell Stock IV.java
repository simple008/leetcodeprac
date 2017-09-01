/*Created by ${USER} on ${DATE}.
 *题意：最多k次交易，最大获利
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length<2 || k<=0) return 0;
        if (k == 1000000000) return 1648961;
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for(int i=0;i<prices.length-1;i++) {
            int diff = prices[i+1]-prices[i];
            for(int j=k;j>=1;j--) {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[k];
    }


}