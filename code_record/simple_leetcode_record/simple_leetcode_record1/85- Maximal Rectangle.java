/*Created by ${USER} on ${DATE}.
 *题意：数组数字代表矩形高度，求最大矩形面积
 *注意：
 *思路：用一个一维数组 依次遍历各行，记录每行的情况。然后用84求最大面积的方法求出来，如果遇到一个0那么这个就清零了。
 * 看有多少个累加的一 并且能和前后的累计一 连起来组成一个大矩形
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max=0;
        int length=matrix[0].length;
        int []height=new int[length];



        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0') height[j]=0;
                else height[j]=height[j]+1;

                // height[j]=matrix[i][j]==0?0:(height[j]+1);
            }
            max=Math.max(max,largestRectangleArea(height));
        }
        return max;
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxa=0;
        for(int i=0;i<=heights.length;i++){
            int curt = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty()&&curt <=heights[stack.peek()]){
                int h=heights[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                maxa=Math.max(maxa,h*w);
            }
            stack.push(i);
        }
        return maxa;
    }
}