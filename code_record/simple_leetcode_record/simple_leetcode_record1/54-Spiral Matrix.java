/*Created by ${USER} on ${DATE}.
 *题意：旋转输出数组的值
 *注意：
 *思路：设定四个方向的界值，旋转输出。
 *一刷：每输出一个方向就将相应的界值做操作，并比较是否是符合要求的，
 *二刷：1.做四次循环输出之后再对相应的界值做操作，最后比较相同的情况。
 *        2.循环的时候 每次都会把行/列的最后一个元素剩下 等待下一次循环
 *复杂度分析：
 *反思：
 *注意各种corner 情况  一行 一列  两行两列
 */
//第一次
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list=new ArrayList<Integer>();
        if(matrix==null||matrix.length==0) return list;
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;

        while(true){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom)break;
            for(int i=top;i<=bottom;i++){
                list.add(matrix[i][right]);
            }
            right--;
            if(right<left) break;
            for(int i=right;i>=left;i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(bottom<top) break;
            for(int i=bottom;i>=top;i--){
                list.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;
        }
        return list;



    }

}

//第二次
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix.length==0) return list;
        int right=matrix[0].length-1;
        int bottom=matrix.length-1;

        int top=0; ;int left=0;
        while(left<right&&top<bottom){
            for(int j=left;j<right;j++){
                list.add(matrix[top][j]);
            }
            for(int i=top;i<bottom;i++){
                list.add(matrix[i][right]);
            }
            for(int j=right;j>left;j--){
                list.add(matrix[bottom][j]);
            }
            for(int i=bottom;i>top;i--){
                list.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }

        if(left==right){
            for(int i=top;i<=bottom;i++)
                list.add(matrix[i][left]);
        }
        else{
            if(top==bottom)   //这个地方一定要有，注意各种corner 一行 一列 两行 两列
                for(int j=left;j<=right;j++)
                    list.add(matrix[top][j]);
        }
        return list;
    }
}