/*Created by ${USER} on ${DATE}.
*���⣺����Ͱ�ı��ظ߶�ʢˮ�������ʢˮ��
*˼·�����������м��ߣ���һ��ھͽ���һ�����м��ƶ������ϼ�¼���ֵ
*һˢ��
*��ˢ��
*���Ӷȷ�����
*��˼��
*/


public class Solution {
    public int maxArea(int[] height) {
        if(height.length<=1||height==null) return 0;
        int l=0;int r=height.length-1;
        int max=0;
        while(l<=r){
            max=Math.max(max,Math.min(height[l],height[r])*(r-l));
            if(height[l]<=height[r])
                l++;
            else r--;
        }
        return max;
    }
}

/*
�����˸�ԭ����ֵ���бȽ� Math.max(max,xxxx)
 */
    public int maxArea(int[] height) {
        if(height==null||height.length<2) return 0;
        int left=0;
        int right=height.length-1;
        int max=0;
        while(left<right){
            if(height[left]<height[right]){
                max=Math.max(max,height[left]*(right-left));
                left++;
            }else{
                max=Math.max(max,height[right]*(right-left));
                right--;
            }
        }
        return max;
    }