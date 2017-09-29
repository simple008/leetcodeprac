/*Created by ${USER} on ${DATE}.
 *题意：给两个有序的数组 找出两个数组总体的中位数
 *注意：
 *思路：利用找 第k大的数字来解
 *
 *一刷：看的分析 不好理解
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+nums2.length;
        if(len%2==0)
            return (findKth(nums1,0,nums2,0,len/2)+findKth(nums1,0,nums2,0,len/2+1))/2.0;
        else
            return findKth(nums1,0,nums2,0,len/2+1);
    }
    public double findKth(int A[],int A_start,int B[],int B_start,int k){
        if(A_start>=A.length)
            return B[B_start+k-1];
        if(B_start>=B.length)
            return A[A_start+k-1];
        if(k==1)
            return Math.min(A[A_start],B[B_start]);
        int A_key=A_start+k/2-1<A.length?A[A_start+k/2-1]:Integer.MAX_VALUE;
        int B_key=B_start+k/2-1<B.length?B[B_start+k/2-1]:Integer.MAX_VALUE;
        if(A_key<B_key)
            return findKth(A,A_start+k/2,B,B_start,k-k/2);
        else
            return findKth(A,A_start,B,B_start+k/2,k-k/2);
    }
}
