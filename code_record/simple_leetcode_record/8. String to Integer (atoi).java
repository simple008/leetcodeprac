/*Created by ${USER} on ${DATE}.
*���⣺ʵ��C++�е�atoi���������ַ���ת��������  ע�����corner����
*˼·��ע���ķ�������⣺1.��ͷ�Ŀո� 2.���������� 3.��Ч�ַ�������Ч�ַ�������Ч�ַ�֮ǰ�Ľ��������0
*4.����Ƿ�Խ��  ����һ��ȫ����������i��
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��
*/

public class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        int len=str.length();

        long sum=0;
        boolean zf=true;
        if (str.equals("")) return 0;
        int fir=str.charAt(0);
        if (fir==43)
            zf=true;
        else if(fir==45)
            zf=false;
        else if(fir>=48&&fir<=57)
            sum=fir-48;
        else return 0;
        for(int i=1;i<len;i++)
        {
            if(str.charAt(i)<48||str.charAt(i)>=58)
                break;

            sum=sum*10+(str.charAt(i)-'0');
//            if(sum > Integer.MAX_VALUE)
//                sum=Integer.MAX_VALUE;
            if(zf==true&&sum>=Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if(zf==false&&sum >Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
//            else if(zf==true&&sum == Integer.MAX_VALUE)
//                return Integer.MIN_VALUE;
        }

        sum=zf?sum:-sum;

        return (int)sum;
    }
}

/*
ע���Ƿ�ᳬ��long�Ľ���
 */
public class Solution {
    public int myAtoi(String str) {
        if(str==null||str.length()==0) return 0;
        int i=0;
        boolean flag=true;
        while(str.charAt(i)==' ') i++; //ȥ����ͷ�Ŀո�
        if(str.charAt(i)=='+'){  //�������ж�
            i++;
        }
        else if(str.charAt(i)=='-'){
            flag=false;
            i++;
        }
        long res=0;
        while(i < str.length()){
            int bit=str.charAt(i)-'0';
            if(bit<0||bit>9){//�������Ч�ַ��򷵻ص�ǰ�Ľ��
                break;
            }
            res=res*10+bit;
            i++;
            if(res>Integer.MAX_VALUE) break;  //�ж��Ƿ���ڱ����Ĺ�����Խ��long���Ͻ�
        }
        res=flag==true?res:-res;
        if(res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(res<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)res;
    }
}