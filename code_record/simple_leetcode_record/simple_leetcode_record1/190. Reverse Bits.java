/*Created by ${USER} on ${DATE}.
 *题意：32位无符号数按二进制reverse
 *注意：
 *思路：位移
 *一刷：
 *二刷：
 *复杂度分析：
 *反思：
 */
//第一次
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a=0;
        // int b=1;
        for(int i=0;i<32;i++){
            a+=n&1;
            n=n>>1;
            if(i<31){
                a=a<<1;}
        }
        return a;
    }
}

//第二次
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int a=0;
        // int b=1;
        for(int i=0;i<32;i++){
            a+=(n&1)<<(31-i);
            n=n>>1;
        }
        return a;
    }
}
