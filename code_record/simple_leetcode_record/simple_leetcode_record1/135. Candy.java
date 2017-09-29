/*Created by ${USER} on ${DATE}.
 *���⣺N������վһ�ţ�ÿ�˶������������ǣ�ÿ������һ�飬�����ߵı�������ڵ������͵ĺ��ӷֵĶࡣ������Ҫ������
 *ע�⣺
 *˼·��ÿ��ȷ��һ���ǡ��Ƚ����֣���ȷ�������ߵ��˱�ǰ��ķ����͵��˶ࡣ��ȷ�������ߵ��˱Ⱥ�������͵��˶ࡣ
 *һˢ��O(N)space
 *��ˢ��O(1)space  ��������ͱȽ�ţ����
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int candy(int[] rating) {
        int len=rating.length;
        int [] candy=new int[len];
        for(int i=0;i<len;i++){
            candy[i]=1;
        }
        for(int i=1;i<len;i++){
            if(rating[i]>rating[i-1])
                candy[i]=candy[i-1]+1;
        }
        for(int i=len-2;i>=0;i--){
            if((rating[i]>rating[i+1])&&(candy[i]<=candy[i+1]))
                candy[i]=candy[i+1]+1;
        }
        int num=0;
        for(int i=0;i<len;i++){
            num+=candy[i];
        }
        return num;
    }
}