/*Created by ${USER} on ${DATE}.
 *题意：0 1 2 乱序，不用sort方法实现排序 0-1-2
 *注意：
 *思路：双指针遍历
 *一刷：两次遍历，第一次记录0 1 2 的数量，第二次遍历数组改变数值
 *二刷：双指针 使用了交换的方法 扫描0 2 ，0放到前面的指针位置同时扫描位置++，2放到后面的位置，扫描位置不变，因为有可能这次会换过来一个0，不能漏
 *复杂度分析：O(n)
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public void sortColors(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {count0++;}
            if (nums[i] == 1) {count1++;}
            if (nums[i] == 2) {count2++;}
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < count0) {nums[i] = 0;}
            else if (i < count0 + count1) {nums[i] = 1;}
            else {nums[i] = 2;}
        }
    }

}

//第二次
public class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int right=nums.length-1;
        for(int i=0;i<=right;i++){
            if(nums[i]==0){
                swap(nums,i,left);
                left++;
            }else if(nums[i]==2){
                swap(nums,i,right);
                right--;
                i--;
            }
        }
    }
    public void swap(int []nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}