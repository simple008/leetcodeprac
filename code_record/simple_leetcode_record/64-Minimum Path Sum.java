/*Created by ${USER} on ${DATE}.
 *题意：矩阵代表这个点需要的代价，求从左上角到右下角的最小代价
 *注意：
 *思路：dp问题，先初始化第一行第一列 dp[i][j]=grid[i][j]+min(dp[i][j-1],dp[i-1][j]);
 *一刷：
 *二刷：ok 注意题意一次理解准确 ，要细心
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0||grid==null) return 0;
        int m=grid.length;
        int n=grid[0].length;
        int [][]res=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0)
                    res[i][j]=grid[i][j];
                else if(i==0) res[i][j]=res[i][j-1]+grid[i][j];
                else if(j==0) res[i][j]=res[i-1][j]+grid[i][j];
                else res[i][j]=Math.min(res[i][j-1],res[i-1][j])+grid[i][j];
            }
        }
        return res[m-1][n-1];
    }
}
//第二次
public class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        int dp[][]=new int [m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++)
            dp[i][0]=grid[i][0]+dp[i-1][0];
        for(int j=1;j<n;j++)
            dp[0][j]=grid[0][j]+dp[0][j-1];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m-1][n-1];
    }
}