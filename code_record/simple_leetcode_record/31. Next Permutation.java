/*Created by ${USER} on ${DATE}.
 *题意：给一个组合找出下一个排列数组合 按照逻辑顺序
 *注意：
 *思路：从后往前找找到第一个降序的组合，记录这个组合靠前的数值target，从后往前找找到第一个大于target的值进行交换，然后再将这个位置之后的数统一逆序
 *一刷：方法类似 还需要进一步加深
 *二刷：
 *复杂度分析：
 *反思：了解逻辑排列数的顺序，从后往前必须是降序的
 *
 *
 */

//第一次
public class Solution {
    public void nextPermutation(int[] num) {
        int i=num.length-1;
        while(i>0&&(num[i-1]>=num[i]))
            i--;
        if(i==0){
            reverse(num,0,num.length-1);
            return ;
        }
        int j=num.length-1;
        while(j>=i&&num[j]<=num[i-1])
            j--;

        int temp=num[i-1];
        num[i-1]=num[j];
        num[j]=temp;
        reverse(num,i,num.length-1);
    }


    public void reverse(int[] num, int start, int end) {
        int s=start;
        int e=end;
        while(s<e){
            int tem=num[s];
            num[s]=num[e];
            num[e]=tem;
            s++;
            e--;
        }
    }
}


//第二次
public class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        int j=nums.length-1;
        int target =0;
        while(i>0){

            if(nums[i]>nums[i-1]){
                while(j>=i&&nums[j]<=nums[i-1]){
                    j--;
                }
                swap(i-1,j,nums);
                reverse(nums,i,nums.length-1);
                break;
            }
            else i--;
        }
        if(i==0){
            reverse(nums,0,nums.length-1);
        }
    }
    public void swap(int a,int b,int []nums){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void reverse(int []nums,int a,int b){
        while(a<b){
            swap(a,b,nums);
            a++;
            b--;
        }
    }
}

//参考代码  原理相同更简洁些
//先从数组后部向前部找第一个正序的数对，比如(2, 3)，(2, 4)一类。找到这第一个正序队之后，我们要另外设置一个变量j，
// 也是从数组后部向前部查找，找第一个值nums[j] > nums[i]，比如(2, 3, 1)。 找到之后我们要swap(i, j)，这样就
//能保持 i + 1到 nums.length - 1这些数字呈现一个降序的排列，然后我们再reverse(i + 1, nums.length - 1)就可以了。
// 假如数组中没有正序的数对，那么我们根据题意要对整个数组进行逆序。

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        swap(nums, i, j);
                        reverse(nums, i + 1, nums.length - 1);
                        return;
                    }
                }
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}