/*Created by ${USER} on ${DATE}.
 *���⣺ɾ���������ظ����ֵ����֣�ÿ�����ֳ��ֵĴ������������� Ҫ��O(n)ʱ�� O(1)�ռ�
 *˼·������ָ�룬һ���������飬һ��ָ��ǰ��ȥ�ز��ֵ���һλ���Ƚ���ȥ�ز��ֵĵ����ڶ�λ�뵱ǰָ��Ĵ�С ͬ26�� ֻ�ǱȽϵ�λ����ǰŲһλ
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++)
        {
            if(a<2||nums[i]>nums[a-2])
                nums[a++]=nums[i];

        }
        return a;
    }

}

/*
û������
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=2;
        if(nums==null) return 0;
        if(nums.length<3) return nums.length;
        for(int i=2;i<nums.length;i++){
            if(nums[i]>nums[index-2])
                nums[index++]=nums[i];
        }
        return index;
    }
}
