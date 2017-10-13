/*Created by ${USER} on ${DATE}.
 *���⣺ ������Ʊ��Ҫ�䶳һ��
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int buy=-prices[0],sell=0,rest=0;
        for(int i=0;i<prices.length;i++){
            int new_buy = Math.max(rest-prices[i],buy);// ������ ǰһ����Ϣ������ ������������
            int new_sell = Math.max(sell,buy+prices[i]);// ������ ������ ����������ӽ���ļ۸�
            int new_rest = Math.max(rest,sell);//��Ϣ  ������Ϣ �ͽ�����
            buy=new_buy;
            sell=new_sell;
            rest=new_rest;
        }
        return Math.max(sell,rest);
    }
}


˼·����Ҫ�������б����ڵģ���һ��dp���⣬������������buy[i]��ʾ�ڵ�i�����ˣ�sell[i]��ʾ�ڵ�i������֮����������

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