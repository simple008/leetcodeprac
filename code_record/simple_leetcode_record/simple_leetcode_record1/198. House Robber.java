/*Created by ${USER} on ${DATE}.
 *题意：盗贼不能连续偷两家，求最多偷多少价值
 *注意：
 *思路：dp
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */



//第三次
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i =2; i < nums.length; i++){
            dp[i]= Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }
}