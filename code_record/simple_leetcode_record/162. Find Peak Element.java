/*Created by ${USER} on ${DATE}.
 *题意：peekElement  比前后两个数都大的数叫做peakElement，返回任一peakElement的索引值，默认num[-1] = num[n] = -∞
 *注意：
 *思路：
 *一刷：1. 用二分的方式去寻找一个顶峰。
 *二刷：1. 处理特殊情况，长度为1时  然后遍历1 ~ n-2 找peakElement
 *复杂度分析：
 *反思：
 */

public class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right)
        {
            int  mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1])
            {
                left = mid + 1;
            }
            else // nums[mid] > nums[mid - 1]
            {
                right = mid;
            }
        }
        return left;
    }
}
//第二次
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return 0;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]){
                return i;
            }
        }
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        return 0;
    }
}