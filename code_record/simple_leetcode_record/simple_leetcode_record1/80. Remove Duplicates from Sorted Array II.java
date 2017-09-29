/*Created by ${USER} on ${DATE}.
 *题意：删除数组中重复出现的数字，每个数字出现的次数不多于两次 要求O(n)时间 O(1)空间
 *思路：两个指针，一个遍历数组，一个指向当前已去重部分的下一位，比较已去重部分的倒数第二位与当前指针的大小 同26题 只是比较的位置向前挪一位
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        int a=0;
        for(int i=0;i<nums.length;i++)
        {
            if(a<2||nums[i]>nums[a-2])
                nums[a++]=nums[i];

        }
        return a;
    }

}

/*
没有问题
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int index=2;
        if(nums==null) return 0;
        if(nums.length<3) return nums.length;
        for(int i=2;i<nums.length;i++){
            if(nums[i]>nums[index-2])
                nums[index++]=nums[i];
        }
        return index;
    }
}
