/*Created by ${USER} on ${DATE}.
*���⣺����һ���ַ������ҳ�һ�����в��ظ��ַ�������Ӵ�
*˼·��hashset������hash�Ĵ�С�����ظ��ַ�ʱ��ǰ���ɾֱ������ַ���ɾ����������ַ�
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��Ҫ��whileѭ�� ������forѭ�� ��һ���ַ��Ѿ��ڼ����д���ʱҪ�����ڼ������ǰ��Ԫ�ؿ�ʼɾ����ֱ��ɾ������ַ�����
 * �����в��ܰ�����ַ��ӽ��������Ƚϣ������forѭ����ôֻ����һ��
 * Ҳ������hashmap  ��¼��ǰ�ظ����ֵ��ַ���һ�γ��ֵ�λ�õ����ڵ�λ�þ��Ǳ���ɨ�����Ӵ���max���Ƚ�
*/


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }
}
/*
����˵�һ�ε�˼·  ���˼·�е��񻬶����ڵ���˼
 */

public class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set=new HashSet<>();
        int j=0;int i=0;int max=0;
        while(i<s.length()){
            char a=s.charAt(i);
            if(!set.contains(a)){
                set.add(a);
                max=Math.max(set.size(),max);
                i++;
            }
            else{
                set.remove(s.charAt(j++));
            }
        }
        return max;
    }
}