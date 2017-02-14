/*Created by ${USER} on ${DATE}.
 *题意：类似上一题 给一个数组 和一个目标值 找出数组中三个数的和最接近目标值 给出这个和
 *注意：
 *思路：先排序，两个指针夹逼，计算三个数的和与给定值差的绝对值，与当前作比较确定是否更新
 *一刷：
 *二刷：每确定一个组合之后就计算绝对值的差，然后再进行判断和更新，更新时注意去重
 *复杂度分析：
 *反思：
 *
 *
 */
//time 1 99% 很快
//
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int close=0,min=Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len=nums.length;
        for(int i=0;i<len;i++){
            int j=i+1;int k=len-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==target){
                    return target;
                }
                else if(nums[i]+nums[j]+nums[k]<target){
                    while(j<k&&nums[i]+nums[j]+nums[k]<target)     //如果是j<k不满足条件，那么返回上层循环之后也不满足条件会跳出循环，如果是<target不满足条件
                                                                    //那么下次循环回计算这个组合的情况
                        j++;
                    if(Math.abs(min)>Math.abs(target-nums[i]-nums[j-1]-nums[k])) //找出在当前条件下小于且最接近target的组合
                        min=target-nums[i]-nums[j-1]-nums[k];

                }
                else if(nums[i]+nums[j]+nums[k]>target){
                    while(j<k&&nums[i]+nums[j]+nums[k]>target)
                        k--;
                    if(Math.abs(min)>Math.abs(target-nums[i]-nums[j]-nums[k+1]))//找出在当前条件下大于且最接近target的组合
                        min=target-nums[i]-nums[j]-nums[k+1];
                }
            }
        }
        // close=target-min;
        return target-min;
    }
}

//time 2
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min=Integer.MAX_VALUE;
        int closest=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==target)
                    return target;
                else if(sum<target){
                    while(j<k&&nums[j]==nums[j+1])
                    j++;
                    j++;
                }
                else{
                    while(j<k&&nums[k]==nums[k-1])
                    k--;
                    k--;
                }
                if(Math.abs(min)>Math.abs(target-(sum))){
                    min=Math.abs(target-(sum));
                    closest=sum;
                }
            }
        }
        return closest;
    }
}