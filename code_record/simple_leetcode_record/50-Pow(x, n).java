/*Created by ${USER} on ${DATE}.
 *���⣺ʵ�ֳ˷�����
 *ע�⣺ �����ݹ�����ã��Լ������ĳ�������
 *˼·���ݹ�
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��  1.�������÷�ʱ����ܶ�myPow(x,n/2)*myPow(x,n/2)   myPow(myPow(x,n/2),2)
 *         2.Ҫ�к����ĳ��� n==2  ������ѭ�������һ���� �����pow(x,2) ���û��2 ѭ������
 */
//��һ��
public class Solution {
    public double myPow(double x, int n) {
        if(n<0) return 1/x * myPow(1/x, -(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        if(n%2==0) return myPow( myPow(x, n/2), 2);
        else return x*myPow( myPow(x, n/2), 2);
    }
}
//�ڶ���
public class Solution {
    public double myPow(double x, int n) {
        if(n<0) return (1/x)*1/myPow(x,-(n+1));
        if(n==0) return 1;
        if(n==2) return x*x;
        // if(n%2==0) return myPow(x,n/2)*myPow(x,n/2);
        // if(n%2==1) return x*myPow(x,n/2)*myPow(x,n/2);
        if(n%2==0) return myPow(myPow(x,n/2),2);
        if(n%2==1) return x*myPow(myPow(x,n/2),2);
        return 0;
    }
}