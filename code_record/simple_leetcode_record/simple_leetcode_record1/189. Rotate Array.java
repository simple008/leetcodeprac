/*Created by ${USER} on ${DATE}.
 *题意：翻转数组的前k个数 用k step   1234567 4567123
 *注意：
 *思路：这个k补不好理解，  第二次的做法是先调整两部分 然后再整体reverse
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次
public class Solution {
    public void rotate(int[] nums, int k) {

        int n=nums.length;
        if(n<=1) return ;
        k=k%n;

        Solution a=new Solution();
        a.swap(nums,0,n-k-1);
        a.swap(nums,n-k,n-1);
        a.swap(nums,0,n-1);
    }
    public void swap(int[]arr,int start,int end){
        // for(;start<end;start++,end--)
        while(start<end)
        {
            int temp =arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
//第二次

public class Solution {
    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l++] = nums[--r];
            nums[r] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = (n == 0 ? 0 : k % n);
        reverse(nums, 0    , n - k);
        reverse(nums, n - k, n    );
        reverse(nums, 0    , n    );
    }
}