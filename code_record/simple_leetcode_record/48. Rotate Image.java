/*Created by ${USER} on ${DATE}.
 *题意：把一个n*n矩阵顺时针转90°
 *注意：写出正向坐标  反回来交换
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix==null) return ;
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                reverse(matrix,i,j);
            }
        }
    }
    public void reverse (int [][] arr,int a,int b){
        int num=arr[a][b];
        int n=arr.length;
        arr[a][b]=arr[n-b-1][a];
        arr[n-b-1][a]=arr[n-a-1][n-b-1];
        arr[n-a-1][n-b-1]=arr[b][n-a-1];
        arr[b][n-a-1]=num;
    }
}
//第二次
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix[0].length==0) return ;
        int top=0;
        int left=0;
        int len = matrix[0].length;
        int right = len - 1 ;
        for(int i=0;i<len/2;i++){
            for(int j=left;j<right;j++){
                swap(matrix,i,j,len-1);
            }
            left++;
            right--;
        }
    }
    public void swap(int [][]nums,int i, int j, int index){
        int temp=nums[i][j];
        nums[i][j]=nums[index-j][i];
        nums[index-j][i]=nums[index-i][index-j];
        nums[index-i][index-j]=nums[j][index-i];
        nums[j][index-i]=temp;
    }
}