/*Created by ${USER} on ${DATE}.
*题意：给定一个字符串，找出一个含有不重复字符的最长的子串
*思路：hashset，计算hash的大小。有重复字符时从前向后删直到这个字符被删除再往里加字符
*一刷：
*二刷：
*复杂度分析：
*反思：要用while循环 不能用for循环 当一个字符已经在集合中存在时要从现在集合中最靠前的元素开始删除，直到删到这个字符不在
 * 集合中才能把这个字符加进来继续比较，如果用for循环那么只跳过一次
 * 也可以用hashmap  记录当前重复出现的字符上一次出现的位置到现在的位置就是本次扫描的最长子串与max作比较
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
借鉴了第一次的思路  这个思路有点像滑动窗口的意思
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