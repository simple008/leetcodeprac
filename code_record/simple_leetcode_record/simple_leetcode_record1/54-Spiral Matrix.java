/*Created by ${USER} on ${DATE}.
 *���⣺��ת��������ֵ
 *ע�⣺
 *˼·���趨�ĸ�����Ľ�ֵ����ת�����
 *һˢ��ÿ���һ������ͽ���Ӧ�Ľ�ֵ�����������Ƚ��Ƿ��Ƿ���Ҫ��ģ�
 *��ˢ��1.���Ĵ�ѭ�����֮���ٶ���Ӧ�Ľ�ֵ�����������Ƚ���ͬ�������
 *        2.ѭ����ʱ�� ÿ�ζ������/�е����һ��Ԫ��ʣ�� �ȴ���һ��ѭ��
 *���Ӷȷ�����
 *��˼��
 *ע�����corner ���  һ�� һ��  ��������
 */
//��һ��
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

//�ڶ���
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
            if(top==bottom)   //����ط�һ��Ҫ�У�ע�����corner һ�� һ�� ���� ����
                for(int j=left;j<=right;j++)
                    list.add(matrix[top][j]);
        }
        return list;
    }
}