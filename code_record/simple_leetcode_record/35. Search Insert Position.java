/*Created by ${USER} on ${DATE}.
 *题意：将一个数插入一个升序的数组仍然保持递增，找出插入位置
 *注意：
 *思路：
 *一刷：讨论极端情况，target<=min  target>=max  普通情况遍历
 *二刷：二分查找
 *复杂度分析：
 *反思：为什么二分还没有一次遍历 快？
 *
 *
 */
//第一次  一次遍历
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0||nums==null) return 0;
        if(nums[0]>=target) return 0;
        if(nums[nums.length-1]<target) return nums.length;
        int i=1;
        for(i=1;i<nums.length-1;i++){
            if(nums[i]>=target&&nums[i-1]<target) return i;
        }
        return i;
    }
}

//第二次 二分查找
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<right){
            mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;              //不改+1会怎么样
            }
        }
        return nums[left]>=target?left:left+1;
    }
}