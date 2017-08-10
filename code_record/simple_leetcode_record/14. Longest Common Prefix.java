/*Created by ${USER} on ${DATE}.
*题意：找出一个字符串数组中 各个字符串中最长的相同前缀
*思路：从第一个开始作为样本 向后比较 如果后一个没有出现这个样本那么把样本最后一个字符
* 去掉继续比较直到出现之后再比较下一个index
*一刷：
*二刷：
*复杂度分析：
*反思：
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
借鉴第一种方案 使用了java的indexof方法
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
//以第一个为基准遍历后面的所有字符串
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