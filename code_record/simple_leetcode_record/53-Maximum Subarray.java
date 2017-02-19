/*Created by ${USER} on ${DATE}.
 *题意：找出一个数组中累加和最大的子序列的和
 *注意：
 *思路：只有当当前累加和大于零时 加下一个值才可能更大，记录当前累加和cur判断cur是否大于0，域全局最大值作比较
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *如果需要求子序列，那么把记录一下开头和结尾的索引
 */
//第一次
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
//第二次
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