/*Created by ${USER} on ${DATE}.
 *���⣺����n�� 0��׺��0�ĸ���
 *ע�⣺
 *˼·��/5 /5 /5
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

public class Solution {
    public int trailingZeroes(int n) {
        int i=0;
        while(n>0)
        {
            i+=n/5;
            n/=5;
        }
        return i;
    }
}
//�ڶ���

class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += n/5;
            n = n/5;
        }
        return cnt;
    }
}