/*Created by ${USER} on ${DATE}.
 *题意：房子变成了一个环   第一个和最后一个是挨着的
 *注意：
 *思路：分两种情况，第一天偷，第一天不偷。0-n-1   1-n 两次dp
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

After robbing those houses on that street, the thief has found himself a
        new place for his thievery so that he will not get too much attention.
        This time, all houses at this place are arranged in a circle.
        That means the first house is the neighbor of the last one.
        Meanwhile, the security system for these houses remain the same as for those in the previous street.

        Given a list of non-negative integers representing the amount of money of each house,
        determine the maximum amount of money you can rob tonight without alerting the police.

//第一次
public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length<=2) return Math.max(nums[0],nums[nums.length-1]);
        int []max1=new int[nums.length-1];
        int []max2=new int[nums.length-1];

        max1[0]=nums[0];max1[1]=Math.max(nums[0],nums[1]);//第一天偷了
        max2[0]=nums[1];max2[1]=Math.max(nums[2],nums[1]); //第一天没偷

        for(int i=2;i<max1.length;i++){
            max1[i]=Math.max(max1[i-2]+nums[i],max1[i-1]);
        }
        for(int i=2;i<max1.length;i++){
            max2[i]=Math.max(max2[i-2]+nums[i+1],max2[i-1]);
        }
        return Math.max(max1[max1.length-1],max2[max1.length-1]);
    }
}
//第二次

public class Solution {
    public int rob(int[] nums) {
        if(nums.length==0)return 0;
        if(nums.length<=2) return Math.max(nums[0],nums[nums.length-1]);
        int []max1=new int[nums.length];
        int []max2=new int[nums.length];

        max1[0]=nums[0];max1[1]=Math.max(nums[0],nums[1]);//第一天偷了
        max2[1]=nums[1];max2[2]=Math.max(nums[2],nums[1]); //第一天没偷

        for(int i=2;i<max1.length-1;i++){
            max1[i]=Math.max(max1[i-2]+nums[i],max1[i-1]);
        }
        for(int i=3;i<max1.length;i++){
            max2[i]=Math.max(max2[i-2]+nums[i],max2[i-1]);
        }
        return Math.max(max1[max1.length-2],max2[max1.length-1]);
    }
}