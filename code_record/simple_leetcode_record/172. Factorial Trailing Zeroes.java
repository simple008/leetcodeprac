/*Created by ${USER} on ${DATE}.
 *题意：计算n！ 0后缀的0的个数
 *注意：
 *思路：/5 /5 /5
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次

public class Solution {
    public int trailingZeroes(int n) {
        int i=0;
        while(n>0)
        {
            i+=n/5;
            n/=5;
        }
        return i;
    }
}
//第二次

class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        while(n > 0){
            cnt += n/5;
            n = n/5;
        }
        return cnt;
    }
}