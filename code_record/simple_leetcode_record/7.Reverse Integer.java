/*Created by ${USER} on ${DATE}.
*���⣺����һ��int �������ת֮���int 123?321
*˼·���ӵ͵��� ��λȡ��  ע��Խ�����⣬����ȡ�໹�Ǹ���
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��
*/

public class Solution {
    public int reverse(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }
}



/*
����ȡ�����Ǹ��� һ��ע�� ������Ͳ��÷�������۹�һ����
 */

public class Solution {
    public int reverse(int x) {
        long res=0;
        while(x/10!=0||x%10!=0){
            res=res*10+x%10;
            x/=10;
        }
        if(res>Integer.MAX_VALUE) return 0;
        if(res<Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}