/*Created by ${USER} on ${DATE}.
 *���⣺�ҳ���ת�����е���Сֵ
 *ע�⣺
 *˼·��
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼���������������������������
 */
//��һ��
public int findMin(int[] nums) {
        int len=nums.length;
        int left=0;
        int right=len-1;


        while(left<right){
        if(nums[left]<nums[right]) return nums[left];
        int mid=(left+right)/2;
        //   if(nums[left]<nums[mid]){
        //       right=mid;
        //   }

        //   else left=mid+1;
        if(nums[right]<nums[mid])
            left=mid+1;
        else right=mid;

            }
        return nums[left];
        }

//�ڶ���
public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left] < nums[right])
                return nums[left];
            int mid =left+(right-left)/2;
            if(nums[right]<nums[mid]){
                left = mid+1;
            }else
                right =mid;
        }
        return nums[left];
    }
}