/*Created by ${USER} on ${DATE}.
 *题意：求最大乘积子数组
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int a=nums[0],b=nums[0],max=nums[0],min=nums[0],global=nums[0];
        for(int i=1;i<nums.length;i++){
            //   a=nums[i]*max;
            //   b=nums[i]*min;

            //   max=Math.max(nums[i],Math.max(a,b));
            //   min=Math.min(nums[i],Math.min(a,b));

            //   global=Math.max(max,global);
            a = max*nums[i];
            b = min*nums[i];

            max = Math.max(nums[i], Math.max(a, b));
            min = Math.min(nums[i], Math.min(a, b));
            global = Math.max(max, global);
        }
        return global;
    }
}

