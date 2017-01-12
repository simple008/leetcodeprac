/*Created by ${USER} on ${DATE}.
*题意：给定桶的边沿高度盛水，求最大盛水量
*思路：从两侧向中间走，哪一侧第就将哪一侧往中间移动，不断记录最大值
*一刷：
*二刷：
*复杂度分析：
*反思：
*/


public class Solution {
    public int maxArea(int[] height) {
        if(height.length<=1||height==null) return 0;
        int l=0;int r=height.length-1;
        int max=0;
        while(l<=r){
            max=Math.max(max,Math.min(height[l],height[r])*(r-l));
            if(height[l]<=height[r])
                l++;
            else r--;
        }
        return max;
    }
}

/*
忘记了跟原来的值进行比较 Math.max(max,xxxx)
 */
    public int maxArea(int[] height) {
        if(height==null||height.length<2) return 0;
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            if(height[left]<height[right]){
                max=Math.max(max,height[left]*(right-left));
                left++;
            }else{
                max=Math.max(max,height[right]*(right-left));
                right--;
            }
        }
        return max;
    }