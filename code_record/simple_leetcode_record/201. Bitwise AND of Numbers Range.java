/*Created by ${USER} on ${DATE}.
 *���⣺����һ�������䣬����������ڵ�������Ľ��
 *ע�⣺
 *˼·�����޺����ޱȽ��������ȶ�����λ�ƣ�ֱ����ȼ�¼��λ�ƵĴ��������������޵Ľ��������Ӧ��λ����
 *һˢ������ͬ�϶���������ż ����λ�Ʋ���
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(n==0) return 0;
        int move=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            move++;
        }
        return n<<move;

    }
}