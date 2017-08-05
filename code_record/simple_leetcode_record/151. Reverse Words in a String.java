/*Created by ${USER} on ${DATE}.
 *题意：给一个单词字段串，单词之间有空格。逆序这个字符串
 *注意：
 *思路：按空格切割，注意先去除首末尾的空格，以及按照连续空格切割，用正则表达式；
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public String reverseWords(String s) {
        // s.trim();
        String[] str=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--){
            // if(str[i].length()==0||str[i]==null) continue;
            sb.append(str[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
//第二次
public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String [] array = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = array.length-1; i >= 0; i--){
            sb.append(array[i]);
            if(i!=0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
