/*Created by ${USER} on ${DATE}.
 *题意：删除有序数组中的重复元素，所有元素至多出现一次
 *思路：用一个指针index来标记当前处理过的元素的位置，处理过的元素都是已经去除重复值的  因此num[i]>num[index] 说明i和index的值不同可以将i指向
 * 的值放到数组里，否则相同跳过
 * 注意;起始条件判断
 *一刷：
 *二刷：
 *复杂度分析：O(1)  constant memory. constant space
 *反思：
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        for(int n:nums){
            if(i<1||n>nums[i-1])
                nums[i++]=n;
        }
        return i;

    }
}

/*
二刷没有问题，数组遍历用了i的形式 不是：  注意判断条件 是判断nums[i]>nums[index-1] index 和i 是一样的，所以是比较i和index-1
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        if(nums==null||nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[index-1])
                nums[index++]=nums[i];
        }
        return index;
    }
}


