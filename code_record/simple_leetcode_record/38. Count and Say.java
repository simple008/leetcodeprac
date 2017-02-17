/*Created by ${USER} on ${DATE}.
 *题意：数上次的字符串中有多少个数组 并做记录 1122 有两个一两个二 2122 找出第n个排序
 *注意：
 *思路：计数循环就行了，只是题意不好理解。
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public String countAndSay(int n) {
        StringBuilder curr=new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i=1;i<n;i++){
            prev=curr;
            curr=new StringBuilder();
            count=1;
            say=prev.charAt(0);

            for (int j=1,len=prev.length();j<len;j++){
                if (prev.charAt(j)!=say){
                    curr.append(count).append(say);
                    count=1;
                    say=prev.charAt(j);
                }
                else count++;
            }
            curr.append(count).append(say);
        }
        return curr.toString();

    }
}

//第二次
public class Solution {
    public String countAndSay(int n) {
        if(n<=0) return "";
        String res="1";
        int start=1;
        int count=1;
        StringBuilder sb=new StringBuilder();
        while(start<n){
            for(int i=0;i<res.length()-1;i++){
                if(res.charAt(i)==res.charAt(i+1))
                    count++;
                else {
                    sb.append(count);
                    sb.append(res.charAt(i));
                    count=1;
                }
            }
            sb.append(count);
            sb.append(res.charAt(res.length()-1));
            res=sb.toString();
            sb=new StringBuilder();
            start++;
            count=1;
        }
        return res;
    }
}