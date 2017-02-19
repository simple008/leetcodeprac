/*Created by ${USER} on ${DATE}.
 *题意：矩阵中有零的行列都置为零
 *注意：
 *思路：1.两个辅助数组 m n记录各行各列的情况  空间O(m+n）
 *     2.把首行首列作为标识  如果出现0 把首行 首列对应位置置零
 *       两个标识flag单独记录，避免因为 1,1位置是零 把 1,0  0,1置零了最后遍历的时候首行首列都会被置零 全零了
 *       根据首行/列的情况 把除首行/列外的位置遍历 置零，最后根据标识位处理 首行 首列
 *       空间 in space
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

//第二次
public class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        if (n==0) return ;
        int m=matrix[0].length;
        boolean fr=false;
        boolean fc=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    if(i==0) fr=true;
                    if(j==0) fc=true;
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0||matrix[0][j]==0)
                    matrix[i][j]=0;
            }
        }
        if(fr){
            for(int j=0;j<m;j++)
                matrix[0][j]=0;
        }
        if(fc){
            for(int i=0;i<n;i++)
                matrix[i][0]=0;
        }
    }
}