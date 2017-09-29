/*Created by ${USER} on ${DATE}.
 *题意：两次交易的最大利润
 *注意：
 *思路：重点是最多两次，那么就要找到这个中间点。前面是一次获利最大值的计算，后面是一次交易获利最大值的计算。前面的比较好计算，后面的可以从后往前推。
 *  把两次遍历的结果做汇总，取一个最大值。
 *  最多进行两次可以进行一次，什么时候进行一次呢 就用prePro[i]+postPro[i]来确定，如果得到最大值的那一天刚好是既买入又卖出就是只进行一次，把这两种情况合并到一块进行操作了
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;

        int []prePro=new int[prices.length];
        int [] postPro =new int [prices.length];

        int preMin=prices[0];
        for(int i=1;i<prices.length;i++){
            preMin=Math.min(preMin,prices[i]);
            prePro[i]=Math.max(prePro[i-1],prices[i]-preMin);
        }

        int curMax=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            curMax=Math.max(curMax,prices[i]);
            postPro[i]=Math.max(curMax-prices[i],postPro[i+1]);
        }

        int maxPro=0;
        for(int i=0;i<prices.length;i++){
            maxPro=Math.max(maxPro,prePro[i]+postPro[i]);
        }

        return maxPro;

    }
}

//第二次

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int [] prePro = new int[len];
        int [] postPro = new int[len];
        int maxPro = 0;
        int curMin = prices[0];;
        int curMax = prices[len-1];
        int max = 0;
        for(int i = 1; i < prices.length; i ++){
            prePro[i]= Math.max(max ,prices[i]-curMin);
            curMin = Math.min(curMin, prices[i]);
        }

        for(int i = prices.length-2; i >= 0; i--){
            postPro[i] = Math.max(postPro[i+1],curMax - prices[i]);
            curMax = Math.max(curMax, prices[i]);
        }
        for (int i = 0; i < prices.length-1; i++){
            maxPro = Math.max(maxPro,prePro[i]+postPro[i]);

        }
        return maxPro;
    }
}