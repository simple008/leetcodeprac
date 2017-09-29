/*Created by ${USER} on ${DATE}.
 *���⣺������Ʊ�����ʱ�䣬ֻ��һ�ν�����������
 *ע�⣺
 *˼·����¼һ����Сֵ���Ƚϵ�ǰֵ����Сֵ�� ��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

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
//�ڶ���
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