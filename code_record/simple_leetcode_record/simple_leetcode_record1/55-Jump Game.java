/*Created by ${USER} on ${DATE}.
 *题意：给定数组代表移动范围，判断能否到达最后一个位置
 *注意：
 *思路：
 *一刷：cnt  代表为了到达最后一步现在需要走的范围
 *     从后向前找，从倒数第二个位置开始，如果nums[i]>cnt 则从这个位置可以到最后，否则就要前面的步数越过这个位置cnt++
 *二刷：从前往后记录 最大覆盖范围
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public boolean canJump(int[] nums) {
        int cnt=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<=cnt)
                cnt++;
            else
                cnt=0;
        }
        return cnt==0;
    }
}
//第二次
public class Solution {
    public boolean canJump(int[] nums) {
        int maxCover=nums[0];
        for(int i=0;i<nums.length;i++){
            if(i>maxCover)
                return false;
            if(i+nums[i]>maxCover)
                maxCover=nums[i]+i;
            if(maxCover>=nums.length-1)
                return true;
        }
        return true;
    }
}
