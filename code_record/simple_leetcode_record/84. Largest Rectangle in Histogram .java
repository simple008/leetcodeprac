/*Created by ${USER} on ${DATE}.
 *���⣺�������ִ�����θ߶ȣ������������
 *ע�⣺
 *˼·��ά��һ��ջ�����ջΪ�ջ��ߵ�ǰԪ�ر�ջ��Ԫ�ش�peek������ǰԪ�ص�������ջ�����<= ջ��Ԫ�أ�while)��
 * ����ջ��Ԫ�أ�����һ�ξ��������������Ƚϣ� whileѭ�������Ƚ�ջ��Ԫ�أ��ҵ����Ԫ����Ӱ�쵽������λ�ü�¼���max
 *
 *һˢ�������ǰԪ�ر�ջ��Ԫ��С��ô������������о�һ����ջ�����Ԫ�ء�������ǾͲ����˲���careջ��Ԫ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        for(int i=0;i<=heights.length;i++){
            int curt = (i == heights.length) ? -1 : heights[i];
            while(!stack.isEmpty()&&curt <=heights[stack.peek()]){
                int h=heights[stack.pop()];
                int w=stack.isEmpty()?i:i-stack.peek()-1;
                max=Math.max(max,h*w);
            }
            stack.push(i);
        }
        return max;
    }
}

//�ڶ���

