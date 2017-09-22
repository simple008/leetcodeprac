/*Created by ${USER} on ${DATE}.
 *���⣺peekElement  ��ǰ�������������������peakElement��������һpeakElement������ֵ��Ĭ��num[-1] = num[n] = -��
 *ע�⣺
 *˼·��
 *һˢ��1. �ö��ֵķ�ʽȥѰ��һ�����塣
 *��ˢ��1. �����������������Ϊ1ʱ  Ȼ�����1 ~ n-2 ��peakElement
 *���Ӷȷ�����
 *��˼��
 */

public class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            int  mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else // nums[mid] > nums[mid - 1]
            {
                right = mid;
            }
        }
        return left;
    }
}
//�ڶ���
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        return 0;
    }
}