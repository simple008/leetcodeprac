/*Created by ${USER} on ${DATE}.
*题意：给定一个int 型输出反转之后的int 123?321
*思路：从低到高 按位取余  注意越界问题，负数取余还是负数
*一刷：
*二刷：
*复杂度分析：
*反思：
*/

public class Solution {
    public int reverse(int x) {
        long result =0;
        while(x != 0)
        {
            result = (result*10) + (x%10);
            if(result > Integer.MAX_VALUE) return 0;
            if(result < Integer.MIN_VALUE) return 0;
            x = x/10;
        }
        return (int)result;
    }
}



/*
负数取余是是负数 一定注意 在这里就不用分情况讨论归一处理
 */

public class Solution {
    public int reverse(int x) {
        long res=0;
        while(x/10!=0||x%10!=0){
            res=res*10+x%10;
            x/=10;
        }
        if(res>Integer.MAX_VALUE) return 0;
        if(res<Integer.MIN_VALUE) return 0;
        return (int)res;
    }
}