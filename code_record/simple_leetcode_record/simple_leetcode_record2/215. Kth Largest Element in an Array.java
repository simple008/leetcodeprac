/*Created by ${USER} on ${DATE}.
 *题意：一个数组中第k大的数
 *注意：
 *思路：划分
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */

//第一次   9ms
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int[] sortedArray = mergeSort(nums,0,nums.length-1);
        return sortedArray[sortedArray.length-k];
    }
    public int[] mergeSort(int[] nums,int left,int right){
        if(left==right){
            int[] result = new int[1];
            result[0] = nums[left];
            return result;
        }
        int mid = left+(right-left)/2;
        int[] a = mergeSort(nums,left,mid);
        int[] b = mergeSort(nums,mid+1,right);
        return merge(a,b);
    }
    public int[] merge(int[] a, int[] b){
        int[] result = new int[a.length+b.length];
        for(int i=0,j=0,k=0;k<result.length;k++){
            if(i>=a.length) result[k] = b[j++];
            else if(j>=b.length) result[k] = a[i++];
            else if(a[i]<b[j]) result[k] = a[i++];
            else result[k] = b[j++];
        }
        return result;
    }
}

//第二次  32ms

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        //find kth largest is to find (n-k+1)th smallest.
        return helper(nums,nums.length - k,0,nums.length - 1);
    }
    private int helper(int[] nums,int k, int low, int high){
        int mid = partition(nums,low,high);
        if(mid==k) return nums[mid];
        else if(mid>k) return helper(nums,k,low,mid-1);
        else return helper(nums,k,mid+1,high);
    }
    private int partition(int[] nums, int low, int high){
        if(low==high) return low;
        int pivot = nums[high];
        int i = low;
        for(int j = low;j<high;j++){
            if(nums[j]<=pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,high);
        return i;
    }
    private void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
//  8ms
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}