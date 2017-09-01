/*Created by ${USER} on ${DATE}.
 *题意：数组中有一个元素出现了一次，其他元素出现了两次找出这个元素
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
//第二次
public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int n : nums)
            result^=n;
        return result;
    }
}