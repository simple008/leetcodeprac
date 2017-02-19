/*Created by ${USER} on ${DATE}.
 *���⣺����һ�����飬�ҵ����������е�ֵ��͵��ڸ�����һ��ֵ��
 *ע�⣺1.��������2.�����ڵ�ֵ�����ظ�  3.С��ͬһ��ֵ�������� ����3,2,4 ������3 3 ������
 *˼·������һ��hash�����е�ֵ��������O(n),�ٱ���һ������target-nums[i]�Ƿ����hash�У���ʹһ�������ظ�����hash�л�������ֵ�
 * λ�ã�����ʱ��������ǰ������ �ǿ�������  ��3,3,1  6 ע�� 3,2��4, �������Ҫ�ų�������
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����he
 *��˼��O(N)���Ӷ�Ҫ���� �������������ݽṹ������������� ���������������ָ��ǰ���ƶ��ҵ�����ķ�����Ȼ��̫���ʣ�����ȷ��
 *
 *
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++)
        {
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++)
        {
            int com=target-nums[i];
            if(map.containsKey(com)&&map.get(com)!=i)
            {return new int []{i,map.get(com)};

            }
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}

/*

 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums==null||nums.length<2) return new int[]{};
        HashMap<Integer,Integer> map=new HashMap<>();
        int start=0,end=0;
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }
        for (start = 0; start<nums.length; start++){
            if(map.containsKey(target-nums[start])&&start!=map.get(target-nums[start])){
                end=map.get(target-nums[start]);
                break;
            }
        }
        return new int[]{start,end};
    }
}