/*Created by ${USER} on ${DATE}.
 *题意：在一个旋转数组找一个数
 *思路：找到mid值比较
 *注意：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
/*
一刷
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums==null||nums.length==0) return false;
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]<nums[hi]){
                if(nums[mid]<target&&target<=nums[hi])
                    lo=mid+1;
                else hi=mid-1;
            }
            else if(nums[mid]>nums[hi]){
                if(target>=nums[lo]&&nums[mid]>target)
                    hi=mid-1;
                else lo=mid+1;
            }
            else hi--;
        }
        // return nums[lo]==target?true:false;
        return false;
    }
}