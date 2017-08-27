/*Created by ${USER} on ${DATE}.
 *题意：给定两个字符串，判断第二个字符串能不能通过一系列的翻转得到（子串翻转即可）
 *注意：注意前i个 后i个的表示
 *思路：相同的两种方式，前i个/后lenght-i 个分别相对应；前i个和后i个相对应
 *      只要字符数相同就一定能转换出来
 * 1. 先判断字母个数是否相同。不相同false
  *  2. 相同，递归判断前i个和后面的能否分别得到；前面i个能否由后面的得到，后面的能够有子串1的前面i个得到
  *
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];
        for (int i=0; i<s1.length(); i++) {
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }
        for (int i=0; i<26; i++) if (letters[i]!=0) return false;

        for (int i=1; i<s1.length(); i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }
}
//第二次
public class Solution{
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;

        int[] letters = new int[26];
        for(int i = 0; i <s1.length() ; i++){
            letters[s1.charAt(i)-'a']++;
            letters[s2.charAt(i)-'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(letters[i] != 0) return false;
        }

        for(int i = 1; i < s1.length(); i++){
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0,i), s2.substring(s2.length()-i))
                    && isScramble(s1.substring(i), s2.substring(0,s2.length()-i))) return true;
        }
        return false;
    }

}