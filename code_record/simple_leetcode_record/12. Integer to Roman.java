/*Created by ${USER} on ${DATE}.
*���⣺������ת���������֣��о�ûʲô��˼ ��������
*˼·��Ҫ֪���������ֺ��������ֵ�ת������ ������������ĸ��϶���ʾ����  ������900 400 90 40 9 4���ֶ���
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��
*/


public String intToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
             for (int i = 0; i < values.length; i++) {
                 while (number >= values[i]) {
                     number -= values[i];
                     result.append(numerals[i]);
                 }
             }
             return result.toString();
        }