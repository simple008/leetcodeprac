/*Created by ${USER} on ${DATE}.
 *���⣺���ֱ��excel����Ŀ���뷽ʽ
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ�� ע��n--�Ĳ������� ���ľ��ǽ�λ ��26���Ʋ���ȫһ������ʾ1-26 ��26���Ʊ�ʾ0-25 ��Ҫ--֮����ܶ�Ӧ��ȥ
 *���Ӷȷ�����
 *��˼��
 */
//��һ��

public class Solution {
    public String convertToTitle(int n) {
        String a="";
        if(n<=0) return "" ;

        while(n>0)
        {   n--;
            a =String.valueOf((char)(n%26+65)+a);
            n=n/26;
        }
        return a;
    }
}
//�ڶ���
class Solution {
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();

        while(n>0){
            n--;
            sb.insert(0, (char)('A' + n % 26));
            n = n /26;
        }
        return sb.toString();
    }
}

public class Solution {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

}