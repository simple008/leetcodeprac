/*Created by ${USER} on ${DATE}.
 *���⣺�ж�һ���ַ����ǲ��ǻ��ĵģ� ���Դ�Сд�͸��ַ��š� ֻ�������ֺ���ĸ
 *ע�⣺
 *˼·��˫ָ�룬���Ҽбƣ����Ƿ���Ҫ����ַ��ͺ��Խ�����һ���ж�
 *һˢ��ʹ��Character.isDigit(char) ��Character.isLetter(char) ��������
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//first time
public class Solution {
    public boolean isPalindrome(String s) {
        int end=s.length()-1;
        int start=0;
        if(s.equals(" ")||s.length()==0) return true;

        // if(s.length()==1) return isalph(s.charAt(0));

        while(start<end){
            while(start<end&&!isalph(s.charAt(start))){
                // if(start==s.length()-1) return true;
                start++;
            }
            while (start<end&&!isalph(s.charAt(end))){
                // if(end==0) return true;
                end--;
            }

            if(!isSame(s.charAt(start),s.charAt(end)))
                return false;
            start++;
            end--;
            // if(start==end)return true;
        }
        return true;

    }
    public boolean isalph(char ch){
        if ((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9'))
            return true;
        else return false;
    }
    private boolean isSame(char c1, char c2){
        if ((c1 >= '0' && c1 <= '9') || (c2 >= '0' && c2 <= '9')){
            return c1 == c2;
        } else {
            return c1 == c2 || Math.abs(c1 - c2) == 'a' - 'A';
        }
    }
}

//second time
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        if(j < 1) return true;
        s = s.toLowerCase();
        while(i<j){
            if(!isValid(s.charAt(i))){
                i++;
                continue;
            }
            if(!isValid(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
                continue;
            }
        }
        return true;
    }
    public boolean isValid(char c){
        if(Character.isDigit(c) || Character.isLetter(c))
            return true;
        return false;
    }
}






