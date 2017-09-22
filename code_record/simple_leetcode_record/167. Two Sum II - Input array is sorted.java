/*Created by ${USER} on ${DATE}.
 *���⣺���������ҵ�����Ԫ�غ͵��ڸ���ֵ�� ����ֵ������Ԫ�ص���ţ���1��ʼ����
 *ע�⣺
 *˼·��
 *һˢ��˫ָ��б�
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;int j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]<target)
                i++;
            else if(numbers[i]+numbers[j]>target)
                j--;
            else if(numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{};
    }
}
//�ڶ���

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            else
                left++;
        }
        return new int[2];
    }
}