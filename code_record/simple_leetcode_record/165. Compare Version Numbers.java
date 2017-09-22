/*Created by ${USER} on ${DATE}.
 *���⣺�Ƚ���������ŵĴ�С
 *ע�⣺
 *˼·��\\. �з֣� һ�αȽ�    compareTo() ������Ҫ�� Integer������ int û��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */


//��һ��
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i=0; i<length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
//�ڶ���
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len1 = s1.length;
        int len2 = s2.length;
        int length = Math.max(len1, len2);

        for(int i = 0; i < length; i++){
            Integer v1 = i < len1 ? Integer.parseInt(s1[i]) : 0;
            Integer v2 = i < len2 ? Integer.parseInt(s2[i]) : 0;
            int comp  = v1.compareTo(v2);
            if(comp != 0)
                return comp;
        }
        return 0;
    }
}