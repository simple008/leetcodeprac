/*Created by ${USER} on ${DATE}.
 *题意：剑指offer原题   求数组中除了所在位置之外其他位的乘积
 *注意：
 *思路：从前往后走一遍  从后往前来一遍  后往前的时候记一个 tmo值不断更新
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int res[] =new int[nums.length];
        res[0]=1;
        for(int i=1;i<nums.length;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int right=1;
        for(int i=nums.length-1;i>=0;i--){
            res[i]*=right;
            right=nums[i]*right;
        }
        return res;
    }
}