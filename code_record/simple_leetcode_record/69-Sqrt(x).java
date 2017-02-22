/*Created by ${USER} on ${DATE}.
 *题意：给一个整数  求平方
 *注意：
 *思路：二分  mid?x/mid  要用除不能乘（越界） mid>mid/x  else 中判断(mid+1)?x/(mid+1)
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

//第二次
public class Solution {
    public int mySqrt(int x) {
        if(x<=0) return 0;
        int start=1;
        int end=x;
        int mid=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(mid>x/mid){
                end=mid-1;
            }else{
                if((mid+1)>x/(mid+1))
                    return mid;
                else
                    start=mid+1;
            }
        }
        return 1;
    }
}