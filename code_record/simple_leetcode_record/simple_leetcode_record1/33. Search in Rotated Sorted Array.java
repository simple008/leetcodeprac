/*Created by ${USER} on ${DATE}.
 *题意：在一个旋转过的有序数组中判断是否有给定值
 *注意：二分查找的使用
 * while(left<=right)   <时 是需要判断最后的left值来确定是不是找到了目标值 [1,2]
 *思路：二分。取一个mid，判断这个mid'在前半段还是后半段
 *一刷：取了一个mid之后判断target在哪一段 判断逻辑非常复杂
 *二刷：取了一个mid之后判断这个mid在哪一段  判断逻辑相对简单很多
 *复杂度分析：
 *反思：
 */
//第二次
public class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[left]){
                if(nums[mid]>=target&&nums[left]<=target){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<=target&&nums[right]>=target)
                    left=mid;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}