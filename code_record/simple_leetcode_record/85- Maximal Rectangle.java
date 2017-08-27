/*Created by ${USER} on ${DATE}.
 *���⣺�������ִ�����θ߶ȣ������������
 *ע�⣺
 *˼·����һ��һά���� ���α������У���¼ÿ�е������Ȼ����84���������ķ�����������������һ��0��ô����������ˡ�
 * ���ж��ٸ��ۼӵ�һ �����ܺ�ǰ����ۼ�һ ���������һ�������
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
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