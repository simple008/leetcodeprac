/*Created by ${USER} on ${DATE}.
 *题意： 删除在数组中出现的给定值，
 *注意：
 *思路：
 *一刷：从左遍历一遍 建立两个索引一个是遍历用的索引i一个是记录符合要求的值的索引j可以不断覆盖，j<=i 不会引起遍历露缺的问题
 *二刷：左右两个指针夹逼，左右指针遇到符合要求的位置是停下来进行交换，但是leetcode没通过。感觉应该是没问题的 这也是leetcode hint中提供的线索
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次  单侧指针遍历一遍
public class Solution {
    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++)
        {if(nums[i]!=val)
        {nums[j]=nums[i];
            j++;}
        }
        return j;
    }
}

//第二次 双指针前后夹逼
public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0) return 0;
        int left=0,right=nums.length-1;
        while(left<right){
            while(left<right&&nums[left]!=val)
                left++;
            while(left<right&&nums[right]==val)
                right--;
            swap(left,right,nums);
        }
        return right+1;
    }
    public void swap(int a,int b,int []nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}