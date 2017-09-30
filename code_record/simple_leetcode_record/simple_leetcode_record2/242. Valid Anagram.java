/*Created by ${USER} on ${DATE}.
 *题意：判断两个字符串 字符组成是否相同
 *注意：
 *思路：两个数组 记录就可以了
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public boolean isAnagram(String s, String t) {
        int []a=new int[26];
        char [] stringArr = s.toCharArray();
        char [] stringArr1=t.toCharArray();
        if(s.length()!=t.length())
            return false;

        for(int i=0;i<s.length();i++)
        { a[stringArr[i]-'a']++;
            a[stringArr1[i]-'a']--;
        }

        for(int i=0;i<26;i++)
            if(a[i]!=0)
                return false;

        return true;
    }
}

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        char [] S =s.toCharArray();
        char [] T =t.toCharArray();
        Arrays.sort(S);
        Arrays.sort(T);
        String news = new String(S);
        String newt = new String(T);
        if(news.compareTo(newt)==0)
            return true;
        else
            return false;
    }
}