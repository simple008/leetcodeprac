/*Created by ${USER} on ${DATE}.
*���⣺�ҳ�һ���ַ��������� �����ַ����������ͬǰ׺
*˼·���ӵ�һ����ʼ��Ϊ���� ���Ƚ� �����һ��û�г������������ô���������һ���ַ�
* ȥ�������Ƚ�ֱ������֮���ٱȽ���һ��index
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��
*/


public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null) return "";
        String pre=strs[0];
        int i=1;
        while(i<strs.length) {
            while (strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length() - 1);
            i++;
        }
        return pre;
    }
}

/*
�����һ�ַ��� ʹ����java��indexof����
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String pre=strs[0];
        int i=0;
        while(i<strs.length){
            while(strs[i].indexOf(pre)!=0)
                pre=pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }
}
//�Ե�һ��Ϊ��׼��������������ַ���
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";

        for(int j = 0; j < strs[0].length(); j ++)                  // calc in each row
            for(int i = 1; i < strs.length; i ++)                   // calc in each column
                if(j == strs[i].length() || strs[0].charAt(j) != strs[i].charAt(j))
                    return  strs[0].substring(0, j);

        return strs[0];
    }
}