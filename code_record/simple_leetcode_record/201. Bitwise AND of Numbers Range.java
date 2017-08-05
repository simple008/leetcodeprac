/*Created by ${USER} on ${DATE}.
 *题意：给定一个闭区间，求这个区间内的数相与的结果
 *注意：
 *思路：上限和下限比较如果不相等都向右位移，直到相等记录下位移的次数，把现在上限的结果左移相应的位数。
 *一刷：不相同肯定会有奇有偶 继续位移操作
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(n==0) return 0;
        int move=0;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            move++;
        }
        return n<<move;

    }
}