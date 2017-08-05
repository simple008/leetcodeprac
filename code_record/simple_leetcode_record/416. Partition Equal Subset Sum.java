/*Created by ${USER} on ${DATE}.
 *题意：把一个正整数数组分成两部分，两部分和都相等
 *注意：
 *思路：先计算总和，判断能否除以2整除，再用dp，dp数组长度是数组和的一半加1，dp[i]是true的条件是原来数组存在一个p值dp[i-q]是true 那么这个i可以到达
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
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
//第二次
