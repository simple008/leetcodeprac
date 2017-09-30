/*Created by ${USER} on ${DATE}.
 *题意：二维数组找最大的全都是1的正方形
 *注意：
 *思路：动态规划 dp[i][j] 代表 左上角的一片最多的正方形边长
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int [][]dp=new int[m][n];
        int max=0;
        for(int i=0;i<m;i++){
            dp[i][0]=matrix[i][0]-'0';
            max=Math.max(max,dp[i][0]);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i]-'0';
            max=Math.max(max,dp[0][i]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=matrix[i][j]=='0'?0:Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                max=Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}