/*Created by ${USER} on ${DATE}.
 *题意：两个字符串a b，判断字符串c是不是由a b 字符串交替组合而成，顺序不能乱。
 *注意：
 *思路：二阶动态规划，c串的i+j-1位置是否有效与i+j-2位置相关，如果-2位置可以到达，那么判断[i-1][j] 和[i][j-1]是否可达，在判断对应的字符是否是一样的
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 * s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 */


public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1==null&&(s2==s3))||(s2==null&&(s1==s3))) return true;

        int len1=s1.length();
        int len2=s2.length();
        if(len1+len2!=s3.length()) return false;
        boolean dp[][]=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for(int i=0;i<=len1;i++){
            for(int j=0;j<=len2;j++){
                if(dp[i][j]==true
                        ||(i>=1&&dp[i-1][j]==true&&(s1.charAt(i-1)==s3.charAt(i+j-1)))
                        ||(j>=1&&dp[i][j-1]==true&&(s2.charAt(j-1)==s3.charAt(i+j-1))))
                    dp[i][j]=true;
                else dp[i][j]=false;
            }
        }
        return dp[len1][len2];
    }
}