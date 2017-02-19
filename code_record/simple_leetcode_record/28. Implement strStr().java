/*Created by ${USER} on ${DATE}.
 *题意：实现 string 的 indexOf()方法
 *注意：
 *思路：
 *一刷：可以直接用indexOf()方法。。。尴尬
 *二刷：两层循环 暴力比较
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次   方法还是比较巧妙的，比较两个索引的关系
public class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}


//第二次   64.74%
public class Solution {
    public int strStr(String haystack, String needle) {
        int len2=needle.length();
        if(len2==0) return 0;
        int index=0;
        int len1=haystack.length();
        while(index<=(len1-len2)){
            for(int i=0;i<len2;i++){
                if(haystack.charAt(i+index)!=needle.charAt(i))
                    break;
                if(i==len2-1)
                    return index;
            }
            index++;
        }
        return -1;
    }
}