/*Created by ${USER} on ${DATE}.
 *题意： 数组中存在一个出现次数超过一半的元素 求这个元素
 *注意：
 *思路：剑指offer有的
 *一刷：
 *二刷：相比剑指offer 简化了一些 不需要再考虑一些特殊情况  比如最后剩下的这个数是否一定是超过了1/2次
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int majorityElement(int[] array) {

        if(array.length==0) return 0 ;
        int count=0;
        int pre=0;
        for(int i=0;i<array.length;i++){
            if(count==0){
                pre=array[i];
                count=1;
            }
            else if(pre==array[i])
                count++;
            else count--;
        }
        return pre;
    }
}
// 第二次
class Solution {
    public int majorityElement(int[] nums) {

        int times = 1;
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(times == 0){
                pre = nums[i];
                times = 1;
                continue;
            }
            if(nums[i] == pre){
                times++;
            }else{
                times--;
            }

        }
        return pre;
    }
}