/*Created by ${USER} on ${DATE}.
 *题意：找出旋转数组中的最小值
 *注意：
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：几个特殊情况，现在正常有序，
 */
//第一次
public int findMin(int[] nums) {
        int len=nums.length;
        int left=0;
        int right=len-1;


        while(left<right){
        if(nums[left]<nums[right]) return nums[left];
        int mid=(left+right)/2;
        //   if(nums[left]<nums[mid]){
        //       right=mid;
        //   }

        //   else left=mid+1;
        if(nums[right]<nums[mid])
            left=mid+1;
        else right=mid;

            }
        return nums[left];
        }

//第二次
public class Solution {
    public int findMin(int[] nums) {
        if(nums==null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            if(nums[left] < nums[right])
                return nums[left];
            int mid =left+(right-left)/2;
            if(nums[right]<nums[mid]){
                left = mid+1;
            }else
                right =mid;
        }
        return nums[left];
    }
}