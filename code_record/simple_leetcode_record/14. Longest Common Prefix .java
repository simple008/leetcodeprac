/*Created by ${USER} on ${DATE}.
 *题意：给定一个字符串数组 找出字符串数组所有的字符串中最长的前缀字符串
 *注意：
 *思路：先取第一个开始向后比较，如果出现的地址是0 则继续向后比较，否则去掉最后一个字符继续比较直到从第一个索引位置开始出现为止
 *一刷：
 *二刷：ok
 *复杂度分析：
 *反思：
 *
 *
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null||strs.length==0)
            return "";
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