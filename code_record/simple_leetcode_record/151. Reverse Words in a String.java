/*Created by ${USER} on ${DATE}.
 *���⣺��һ�������ֶδ�������֮���пո���������ַ���
 *ע�⣺
 *˼·�����ո��иע����ȥ����ĩβ�Ŀո��Լ����������ո��и��������ʽ��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public String reverseWords(String s) {
        // s.trim();
        String[] str=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            // if(str[i].length()==0||str[i]==null) continue;
            sb.append(str[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
//�ڶ���
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String [] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i >= 0; i--){
            sb.append(array[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
