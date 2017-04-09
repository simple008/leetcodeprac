/*Created by ${USER} on ${DATE}.
 *���⣺���ν��׵��������
 *ע�⣺
 *˼·���ص���������Σ���ô��Ҫ�ҵ�����м�㡣ǰ����һ�λ������ֵ�ļ��㣬������һ�ν��׻������ֵ�ļ��㡣ǰ��ıȽϺü��㣬����Ŀ��ԴӺ���ǰ�ơ�
 *  �����α����Ľ�������ܣ�ȡһ�����ֵ��
 *  ���������ο��Խ���һ�Σ�ʲôʱ�����һ���� ����prePro[i]+postPro[i]��ȷ��������õ����ֵ����һ��պ��Ǽ���������������ֻ����һ�Σ�������������ϲ���һ����в�����
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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

//�ڶ���

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