/*Created by ${USER} on ${DATE}.
 *题意： 不用乘除法和取余来是实现除法运算
 *注意：越界问题，最小的负数/-1时 变为整数 越界
 *      用减法操作 超时
 *思路：
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 *
 *
 */
//第一次
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor==0) return Integer.MAX_VALUE;
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;
        int flag=1; int result=0;
        if(divisor>0&&dividend<0||divisor<0&&dividend>0) flag=-1;
        long ndividend=(long)Math.abs((long)dividend);
        long ndivisor=(long)Math.abs((long)divisor);

        while(ndividend>=ndivisor){
            int cnt=1;
            long temp=ndivisor;
            while((temp<<=1)<=ndividend){
                cnt<<=1;
            }
            result+=cnt;
            ndividend-=(temp>>1);
        }
        return (flag>0)?result:-result;

    }
}
//第二次
