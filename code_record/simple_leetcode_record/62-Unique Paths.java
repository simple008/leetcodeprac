/*Created by ${USER} on ${DATE}.
 *题意：从矩阵左上角走到右下角的方案数
 *注意：简单的dp问题
 *思路：
 *一刷：没有问题
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int uniquePaths(int m, int n) {
        // if(n==1||m==1) return 1;
        int [][]num=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    num[i][j]=1;
                    continue;}

                num[i][j]=num[i][j-1]+num[i-1][j];
            }
        }
        return num[m-1][n-1];

    }
}


//第二次
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][]matrix=new int[m][n];
        for(int i=0;i<m;i++){
            matrix[i][0]=1;
        }
        for(int j=0;j<n;j++){
            matrix[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}