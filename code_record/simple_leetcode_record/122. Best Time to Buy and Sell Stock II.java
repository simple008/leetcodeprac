/*Created by ${USER} on ${DATE}.
 *���⣺���Խ��ж������������ͬһ��ֻ�ܽ���һ�β���������֮ǰ�����Ѿ����������й�Ʊ
 *ע�⣺
 *˼·�������ǰֵ��ǰһ����Ͱ������ֵ�ӽ���
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

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
//�ڶ���
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