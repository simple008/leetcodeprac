/*Created by ${USER} on ${DATE}.
 *题意：给定一个障碍数组，如果是1，则不通。计算从左上角到右下角的路径方案数
 *注意：先考虑 最左上角，再看第一行的情况
 *思路：单看 第一行地一列  如果有一个1 那么往后就不用看了
 *一刷：
 *二刷：先讨论 第一行地一列的情况，但不能像I那样简单初始化，先判断最左上角，再向右向下判断，根据前一个的情况来判断
 *     之后再根据障碍数组的情况 来给dp数组赋值
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // if()
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]num=new int[m][n];
        int a=0;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0]!=1){
                num[i][0]=1;
                continue;
            }
            else if(obstacleGrid[i][0]==1){break;}
        }
        for(int i=0;i<n;i++){
            if(obstacleGrid[0][i]!=1){
                num[0][i]=1;
                continue;
            }
            else if(obstacleGrid[0][i]==1){break;}

        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                {
                    num[i][j]=0;
                    continue;
                }
                num[i][j]=num[i-1][j]+num[i][j-1];

            }
        }
        return num[m-1][n-1];
    }
}



//第二次
public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        int [][]dp=new int[m][n];
        if(grid[0][0]==1) return 0;
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            if(grid[i][0]!=1)
                dp[i][0]=dp[i-1][0];
        }
        for(int j=1;j<n;j++){
            if(grid[0][j]!=1)
                dp[0][j]=dp[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(grid[i][j]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}