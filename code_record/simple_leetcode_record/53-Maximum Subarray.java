/*Created by ${USER} on ${DATE}.
 *���⣺�ҳ�һ���������ۼӺ����������еĺ�
 *ע�⣺
 *˼·��ֻ�е���ǰ�ۼӺʹ�����ʱ ����һ��ֵ�ſ��ܸ��󣬼�¼��ǰ�ۼӺ�cur�ж�cur�Ƿ����0����ȫ�����ֵ���Ƚ�
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 *�����Ҫ�������У���ô�Ѽ�¼һ�¿�ͷ�ͽ�β������
 */
//��һ��
public class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length==0) return 0;
        int cur=nums[0];
        int max=cur;
        for(int i=1;i<nums.length;i++){
            //  max=Math.max(max,cur);
            if(cur<0){

                cur=0;
            }
            cur+=nums[i];
            max=Math.max(max,cur);
        }
        return max;
    }
}
//�ڶ���
public class Solution {
    public int maxSubArray(int[] nums) {
        // if(nums.length==0) return 0;
        int cur=nums[0];
        int max=cur;
        for(int i=1;i<nums.length;i++){
            if(cur<0){
                cur=0;
            }
            cur+=nums[i];
            if(cur>max)
                max=cur;
        }
        return max;
    }
}