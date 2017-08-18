/*Created by ${USER} on ${DATE}.
 *���⣺ɾ�����������е��ظ�Ԫ�أ�����Ԫ���������һ��
 *˼·����һ��ָ��index����ǵ�ǰ�������Ԫ�ص�λ�ã��������Ԫ�ض����Ѿ�ȥ���ظ�ֵ��  ���num[i]>num[index] ˵��i��index��ֵ��ͬ���Խ�iָ��
 * ��ֵ�ŵ������������ͬ����
 * ע��;��ʼ�����ж�
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����O(1)  constant memory. constant space
 *��˼��
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int n:nums){
            if(i<1||n>nums[i-1])
                nums[i++]=n;
        }
        return i;

    }
}

/*
��ˢû�����⣬�����������i����ʽ ���ǣ�  ע���ж����� ���ж�nums[i]>nums[index-1] index ��i ��һ���ģ������ǱȽ�i��index-1
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        if(nums==null||nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[index-1])
                nums[index++]=nums[i];
        }
        return index;
    }
}


