/*Created by ${USER} on ${DATE}.
 *题意：给一个数组  找出最小的步数到最后一位
 *注意：
 *思路：记录当前能到达的最大范围，基础上一步能到达的最大范围。判断当前位置是否在上一步的范围内
 *一刷：
 *二刷：ok
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public int jump(int[] nums) {
        int lastCover=0;
        int maxCover=0;
        int step=0;
        for(int i=0;i<nums.length&&i<=maxCover;i++){
            if(i>lastCover){
                step++;
                lastCover=maxCover;
            }
            if(i+nums[i]>maxCover)
                maxCover=i+nums[i];
        }
        if(maxCover>=nums.length-1){
            return step;
        }
        return 0;
    }
}

//第二次   去掉for循环中i<=maxCover的判断一样可以通过  省略了没有答案的case
public class Solution {
    public int jump(int[] nums) {
        int lastCover=0;
        int maxCover=0;
        int step=0;
        for(int i=0;i<nums.length;i++){
            if(i>lastCover){
                step++;
                lastCover=maxCover;
            }
            if(nums[i]+i>maxCover)
                maxCover=nums[i]+i;
        }
        if(maxCover>=nums.length-1)
            return step;
        return 0;
    }
}