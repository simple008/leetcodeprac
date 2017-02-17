/*Created by ${USER} on ${DATE}.
 *题意：从一个乱序数组中（有正有负） 找出第一个缺失的正数 O(n)时间 原来的空间
 *注意：索引位置，   for循环  过一遍  先把<0的值去掉，再进行空间的交换
 *思路：
 *一刷：用sort 显然达不到要求
 *二刷：用while循环不断交换不符合要求的数值  把i放到i-1位置上  最后用for循环遍历一遍
 *复杂度分析：O(N）
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int a=1;
                for(int j=i;j<nums.length;j++){
                    if(j!=nums.length-1&&(nums[j]==nums[j+1]))
                        continue;
                    else if(nums[j]==a)
                        a++;
                    else return a;
                }
                return a++;
            }
        }
        return 1;
    }
}


//第二次

public class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0) return 1;
        int temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                while(nums[i]>0&&nums[i]<i+1&&nums[i]!=nums[nums[i]-1]){
                    temp=nums[i];
                    nums[i]=nums[nums[i]-1];
                    nums[temp-1]=temp;    //注意交换的时候 i已经变了，要用原来的i
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }
}