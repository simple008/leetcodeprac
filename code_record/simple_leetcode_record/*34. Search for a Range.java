/*Created by ${USER} on ${DATE}.
 *题意：在一个有序的有重复数字的数组中 找出给定值出现位置开始和结束的索引
 *注意：
 *思路：两次二分，第一次找出最先出现的位置，第二次找出最后出现的位置
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int start = Solution.firstsearch(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, Solution.firstsearch(A, target + 1) - 1};
    }
    public static int firstsearch(int []s,int target){
        int low=0;
        int high=s.length;
        while(low<high){
            int mid=(low+high)/2;
            if(s[mid]<target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}

//第二次

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]={-1,-1};
        if(nums.length==0) return res;
        int loleft=0,loright=nums.length-1,hileft=0,hiright=nums.length-1;
        while(loleft<=loright){
            int mid=loleft+(loright-loleft)/2;
            if(nums[mid]<target){
                loleft=mid+1;
            }else{
                loright=mid-1;
            }
        }
        while(hileft<=hiright){
            int mid=hileft+(hiright-hileft)/2;
            if(nums[mid]<=target){
                hileft=mid+1;
            }else{
                hiright=mid-1;
            }
        }
        if(loleft<=hiright){
            res[0]=loleft;
            res[1]=hiright;
        }
        return res;
    }
}