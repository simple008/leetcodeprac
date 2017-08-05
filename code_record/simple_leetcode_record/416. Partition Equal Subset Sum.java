/*Created by ${USER} on ${DATE}.
 *���⣺��һ������������ֳ������֣������ֺͶ����
 *ע�⣺
 *˼·���ȼ����ܺͣ��ж��ܷ����2����������dp��dp���鳤��������͵�һ���1��dp[i]��true��������ԭ���������һ��pֵdp[i-q]��true ��ô���i���Ե���
 *һˢ��
 *��ˢ��
 *���Ӷȷ�����
 *��˼��
 */
//��һ��
public class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0) return false;
        boolean dp[]=new boolean[sum/2+1];
        dp[0]=true;
        for(int i=0;i<nums.length;i++){
            for(int j=sum/2;j>=nums[i];j--){
                dp[j]=dp[j]||dp[j-nums[i]];
            }
        }
        return dp[dp.length-1];
    }
}
//�ڶ���
