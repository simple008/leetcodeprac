/*Created by ${USER} on ${DATE}.
 *题意：求给定的字符串中最长的单词长度
 *注意：
 *思路：
 *一刷： 去掉首尾空字符，找最后一个空字符出现的位置，
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
// 第一次
public class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        return s.length()-s.lastIndexOf(' ')-1;
    }
}

//第二次     分割成字符串数组
public class Solution {
    public int lengthOfLastWord(String s) {
        String[]arr=s.split(" ");
        if (arr.length==0) return 0;
        String last=arr[arr.length-1];
        return last.length();
    }
}
