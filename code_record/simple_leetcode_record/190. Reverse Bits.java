/*Created by ${USER} on ${DATE}.
 *���⣺32λ�޷�������������reverse
 *ע�⣺
 *˼·��λ��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a=0;
        // int b=1;
        for(int i=0;i<32;i++){
            a+=n&1;
            n=n>>1;
            if(i<31){
                a=a<<1;}
        }
        return a;

    }
}

//�ڶ���
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a=0;
        // int b=1;
        for(int i=0;i<32;i++){

            a+=(n&1)<<(31-i);
            n=n>>1;


        }
        return a;

    }
}
