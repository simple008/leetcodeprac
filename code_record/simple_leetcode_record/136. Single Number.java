/*Created by ${USER} on ${DATE}.
 *���⣺��������һ��Ԫ�س�����һ�Σ�����Ԫ�س����������ҳ����Ԫ��
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
//�ڶ���
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums)
            result^=n;
        return result;
    }
}