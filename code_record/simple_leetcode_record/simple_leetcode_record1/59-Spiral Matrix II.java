/*Created by ${USER} on ${DATE}.
 *题意：螺旋生成数组
 *注意：
 *思路：
 *一刷：按照sprial matrix I的第一个思路
 *二刷：按照sprial matrix I的思路 数序生成
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次

public class Solution {
    public int[][] generateMatrix(int n) {
        int [][]matrix=new int[n][n];
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int c=1;
        while(true){
            for(int i=left;i<=right;i++){
                matrix[top][i]=c++;
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                matrix[i][right]=c++;
            }
            right--;
            if(right<left) break;
            for(int i=right;i>=left;i--){
                matrix[bottom][i]=c++;
            }
            bottom--;
            if(bottom<top) break;
            for(int i=bottom;i>=top;i--){
                matrix[i][left]=c++;
            }
            left++;
            if(left>right) break;
        }
        return matrix;

    }
}
//第二次
public class Solution {
    public int[][] generateMatrix(int n) {
        int cnt=1;
        int [][]matrix=new int [n][n];
        int right=n-1;
        int bottom=n-1;

        int top=0; ;int left=0;
        while(left<right&&top<bottom){
            for(int j=left;j<right;j++){
                matrix[top][j]=cnt++;
            }
            for(int i=top;i<bottom;i++){
                matrix[i][right]=cnt++;
            }
            for(int j=right;j>left;j--){
                matrix[bottom][j]=cnt++;
            }
            for(int i=bottom;i>top;i--){
                matrix[i][left]=cnt++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        if(left==right&&cnt<=n*n){
            for(int i=top;i<=bottom;i++)
                matrix[i][left]=cnt++;
        }
        else{
            if(top==bottom&&cnt<=n*n)
                for(int j=left;j<=right;j++)
                    matrix[top][j]=cnt++;
        }
        return matrix;
    }
}

