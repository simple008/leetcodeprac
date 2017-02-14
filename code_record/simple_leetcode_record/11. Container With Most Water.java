/*Created by ${USER} on ${DATE}.
 *题意：给定坐标 找出盛水最大的范围
 *注意：height[right--]  right=1时 是 height[0]
 *思路：从两侧向中间靠拢，记录全局最大值
 *一刷：
 *二刷：没有问题
 *复杂度分析：
 *反思：
 *
 *
 */

//第二次
public class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            if(height[left]>=height[right]){
                max=Math.max(height[right]*(right-left),max);
                right--;
            }
            else {
                max=Math.max(height[left]*(right-left),max);
                left++;
            }
        }
        return max;
    }
}