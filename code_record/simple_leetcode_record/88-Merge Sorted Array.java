/*Created by ${USER} on ${DATE}.
 *题意：给定两个m n 长度的有序数组，合并到1中1的长度足够大
 *注意：
 *思路：从m+n-1位置开始向前补充  当有一个索引小于0时判断是不是长数组如果不是则把剩下的填进来，如果是就不用管了剩下的刚好
 *一刷：ok
 *二刷：从最后一位开始补充是浪费的，从m+n-1开始向前即可
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j])
            {nums1[k]=nums1[i];
                k--;
                i--;
            }
            else {nums1[k]=nums2[j];
                k--;
                j--;}
        }
        while(j>=0)
        {
            nums1[k]=nums2[j];
            k--;
            j--;
        }

    }
}

//第二次 代码失误  不应该从最后开始往前补充 应该从m+n-1开始向前补充
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index=nums1.length-1;
        int len1=m+n;
        while(m-1>=0&&n-1>=0){
            if(nums1[m-1]>nums2[n-1]){
                nums[index--]=nums1[m-1];
                m--;
            }else{
                nums[index--]=nums2[n-1];
                n--;
            }
        }
        for(int i=m-1;i>=0;i--){
            nums[index--]=nums1[m-1];
        }
        for(int i=n-1;i>=0;i--){
            nums[index--]=nums2[n-1];
        }
        for(int i=0;i<len1;i++){
            nums1[i]=nums1[num1.length-len1+i];
        }

    }
}