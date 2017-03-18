/*Created by ${USER} on ${DATE}.
 *题意：
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

public class Solution {
    /**
     * 这个方法用的是动态规划的方法，即针对？ * 和普通字符建立一个矩阵，表示其转移
     * 初始0，0位置匹配
     * 对于每一个位置：
     * 如果是Pattern为*，那么当前位置可以匹配到的条件是，只要他的左边 上边 或者左上 任意有一个可以到就可以了
     * 如果是？或相等，那么条件就是左上可以访问到
     * 如果不是，那么久证明不可以访问到了
     *
     * 估计有比我更好的方法存在的。
     * */

    public boolean isMatch(String s, String p) {
        char S[]=s.toCharArray();
        char P[]=p.toCharArray();
        int n=S.length,m=P.length;
        boolean dp[][]=new boolean[m+1][n+1];
        dp[0][0]=true;
        int start=0; //当前对于每行搜索的时候起始位置的标示，一定不用搜索的位置就是每当Pattern遇到一个非*的地方就可以加1
        for(int i=1;i<=m;i++){ //pattern
            if(P[i-1]=='*') {
                dp[i][0] = dp[i-1][0];
                for(int j=1;j<=n;j++)
                    dp[i][j] = dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j];
            }
            else{
                // start++;
                for(int j=1;j<=n;j++){
                    if(P[i-1]=='?' || P[i-1]==S[j-1]){
                        if(dp[i-1][j-1] == true) //可以访问
                            dp[i][j]=true;
                    }
                }
            }
        }
        return dp[m][n];
    }
}
