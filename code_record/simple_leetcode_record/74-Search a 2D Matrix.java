/*Created by ${USER} on ${DATE}.
 *题意：在有序的矩阵中查找是否有目标值
 *注意：
 *思路：以右上角或者左下角为参考
 *一刷： 计算数组中元素的总个数，用二分的方式来查找，通过对行的长度取模 取余的方式来找到对应值的坐标
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0||matrix[0].length==0) return false;
        int m=matrix.length;
        int j=matrix[0].length;
        int start=0;
        int end= m*j-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            int row=mid/j;
            int col=mid%j;
            if(matrix[row][col]==target)
                return true;
            else if(matrix[row][col]<target)
                start=mid+1;
            else end= mid-1;
        }
        return false;
    }
}
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