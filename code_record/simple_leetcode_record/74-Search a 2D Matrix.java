/*Created by ${USER} on ${DATE}.
 *题意：在有序的矩阵中查找是否有目标值
 *注意：
 *思路：以右上角或者左下角为参考
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

//第二次
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length-1;
        if(matrix.length==0) return false;
        int n=matrix[0].length-1;
        int a=0;
        int b=n;

        while(a<=m&&b>=0){
            if(matrix[a][b]==target)
                return true;
            else if(matrix[a][b]>target)
                b--;
            else a++;
        }
        return false;
    }
}