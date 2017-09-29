/*Created by ${USER} on ${DATE}.
 *题意：给定一个闭区间，求这个区间内的数相与的结果
 * given the range [5, 7], you should return 4.
 *注意：
 *思路：上限和下限比较如果不相等都向右位移，直到相等记录下位移的次数，把现在上限的结果左移相应的位数。
 *一刷：不相同肯定会有奇有偶 继续位移操作
 *二刷：返回的数一定是一个2的幂次，数都是相邻的，等价于高位在哪一位才是相同的
 *复杂度分析：
 *反思：
 */
//第一次
/*The idea is very simple:

        last bit of (odd number & even number) is 0.
        when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
        Move m and n rigth a position.
        Keep doing step 1,2,3 until m equal to n, use a factor to record the iteration time.*/
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

//第二次
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0) return 0;
        int move = 0;
        while(m != n){
            m=m>>1;
            n=n>>1;
            move++;
        }
        return n<<move;
    }
}